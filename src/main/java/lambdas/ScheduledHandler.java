package lambdas;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.ExchangeRate;
import model.ExchangeRateDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import repository.ExchangeRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScheduledHandler{

	private static final Logger logger = LogManager.getLogger(ScheduledHandler.class);

		public void handleRequest() throws IOException {

		URL url = new URL("https://openexchangerates.org/api/latest.json?app_id=17b14b138c454ea99a0b54c22ce946e2");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/xml");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

		ObjectMapper mapper = new ObjectMapper();
		ExchangeRate parsed = mapper.readValue(br, ExchangeRate.class);

		List<ExchangeRateDTO> exchangeRateBatch = getExchangeRateRecords(parsed);

	}

	public List<ExchangeRateDTO> getExchangeRateRecords(ExchangeRate parsed) {
		StringBuilder stringBuilder = new StringBuilder();
		List<ExchangeRateDTO> resultingExchangeRecords = new ArrayList<>();
		int counter = 0;
		for (Map.Entry<String, BigDecimal> firstExchangeRateUSD : parsed.getRates().entrySet()) {
			stringBuilder.append(parsed.getBase())
			             .append("-")
			             .append(firstExchangeRateUSD.getKey())
			             .append("-")
			             .append(firstExchangeRateUSD.getValue())
			             .append(";");
			for (Map.Entry<String, BigDecimal> secondExchangeRateUSD : parsed.getRates().entrySet()) {
				if (firstExchangeRateUSD.getKey().equals(secondExchangeRateUSD.getKey())) continue;
				BigDecimal resultingExchange = secondExchangeRateUSD.getValue()
				                                                    .divide(firstExchangeRateUSD.getValue(), 6, RoundingMode.CEILING);
				counter++;
				stringBuilder.append(firstExchangeRateUSD.getKey())
				             .append("-")
				             .append(secondExchangeRateUSD.getKey())
				             .append("-")
				             .append(resultingExchange)
				             .append(";");

				if (counter % 15000 == 0) {
					ExchangeRateDTO exchangeRateDTO = new ExchangeRateDTO(parsed.getTimestamp(), stringBuilder.toString());
					resultingExchangeRecords.add(exchangeRateDTO);
					stringBuilder.setLength(0);
				}
			}
		}

		ExchangeRateDTO exchangeRateDTO = new ExchangeRateDTO(parsed.getTimestamp(), stringBuilder.toString());
		resultingExchangeRecords.add(exchangeRateDTO);
		stringBuilder.setLength(0);

		ExchangeRepository.getInstance().batchSave(resultingExchangeRecords);

		logger.info("Saved to database");

		return resultingExchangeRecords;
	}
}
