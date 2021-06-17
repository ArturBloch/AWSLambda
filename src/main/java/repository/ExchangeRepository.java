package repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import database.DynamoDBHandler;
import model.exchange_rates.ExchangeRateDTO;

import java.util.List;

public class ExchangeRepository {

	private static ExchangeRepository instance;

	public ExchangeRateDTO save(ExchangeRateDTO exchangeRateDTO) {
		DynamoDBHandler.getInstance().dynamoDBMapper.save(exchangeRateDTO);
		return exchangeRateDTO;
	}

	public List<ExchangeRateDTO> batchSave(List<ExchangeRateDTO> exchangeRates) {
		DynamoDBHandler.getInstance().dynamoDBMapper.batchSave(exchangeRates);
		return exchangeRates;
	}

	public ExchangeRateDTO getExchangeRateDynamoById(String exchangeRateDynamoId) {
		return DynamoDBHandler.getInstance().dynamoDBMapper.load(ExchangeRateDTO.class, exchangeRateDynamoId);
	}

	public PaginatedQueryList<ExchangeRateDTO> findByExchangeDate(String exchangeDateHashKey) {
		ExchangeRateDTO exchangeRateDTO = new ExchangeRateDTO();
		exchangeRateDTO.exchangeDate = exchangeDateHashKey;

		DynamoDBQueryExpression<ExchangeRateDTO> queryExpression = new DynamoDBQueryExpression<ExchangeRateDTO>().withHashKeyValues(
			exchangeRateDTO);

		return DynamoDBHandler.getInstance().dynamoDBMapper.query(ExchangeRateDTO.class, queryExpression);
	}

	public static synchronized ExchangeRepository getInstance() {
		if(instance == null){
			instance = new ExchangeRepository();
		}
		return instance;
	}
}
