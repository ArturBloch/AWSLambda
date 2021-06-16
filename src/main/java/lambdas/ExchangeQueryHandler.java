package lambdas;

import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ExchangeRate;
import model.ExchangeRateDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.ExchangeRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

public class ExchangeQueryHandler {

	private static final Logger logger = LogManager.getLogger(ExchangeQueryHandler.class);

	public APIGatewayProxyResponseEvent handleRequest() throws JsonProcessingException {
		LocalDateTime queryDateTime = LocalDateTime.now();
		List<ExchangeRate> latestRecords = new ArrayList<>();
		String targetHashKey = String.format("%d/%d/%d", queryDateTime.getYear(), queryDateTime.getMonthValue(),
		                                     queryDateTime.getDayOfMonth());
		logger.info("Querying for {}", targetHashKey);
		while (latestRecords.isEmpty()) {
			latestRecords = getRecordsForParticularDay(targetHashKey);
			queryDateTime = queryDateTime.minusDays(1);
		}

		logger.info("Exiting");

		ObjectMapper mapper = new ObjectMapper();

		return new APIGatewayProxyResponseEvent().withStatusCode(200)
		                                         .withBody(mapper.writeValueAsString(latestRecords))
		                                         .withIsBase64Encoded(false);
	}

	public List<ExchangeRate> getRecordsForParticularDay(String requestedHashKey) {
		PaginatedQueryList<ExchangeRateDTO> exchangeRatesDay = ExchangeRepository.getInstance().findByExchangeDate(requestedHashKey);
		logger.info("Queried and got {} results", exchangeRatesDay.size());

		if (exchangeRatesDay.isEmpty()) return new ArrayList<>();

		long maxTimeStamp = exchangeRatesDay.stream().max(Comparator.comparingLong(a -> a.exchangeTimestamp)).get().exchangeTimestamp;
		LocalDateTime timestampDate = LocalDateTime.ofInstant(Instant.ofEpochSecond(maxTimeStamp), ZoneOffset.UTC);
		logger.info("Max timestamp for current query {} equal to {}", maxTimeStamp, timestampDate);
		return transformDBObjectToJsonList(exchangeRatesDay, maxTimeStamp);
	}

	private List<ExchangeRate> transformDBObjectToJsonList(List<ExchangeRateDTO> exchangeRatesDay, long maxTimestamp) {
		HashMap<String, ExchangeRate> jsonExchangeRateMap = new HashMap<>();
		for (ExchangeRateDTO exchangeRateDTO : exchangeRatesDay) {
			if (exchangeRateDTO.exchangeTimestamp != maxTimestamp) continue;
			for (String exchangeRate : exchangeRateDTO.exchangeString.split(";")) {
				String[] currentExchangeRate = exchangeRate.split("-");
				String baseName = currentExchangeRate[0];
				String exchangeCurrName = currentExchangeRate[1];
				BigDecimal exchangeValue = new BigDecimal(currentExchangeRate[2]);
				jsonExchangeRateMap.putIfAbsent(baseName, new ExchangeRate(baseName, exchangeRateDTO.getExchangeTimestamp()));
				jsonExchangeRateMap.get(baseName).getRates().put(exchangeCurrName, exchangeValue);
			}
		}

		return new ArrayList<>(jsonExchangeRateMap.values());
	}
}
