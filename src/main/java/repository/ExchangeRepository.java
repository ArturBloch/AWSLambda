package repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import database.DynamoDBHandler;
import model.exchange_rates.ExchangeRateDTO;

import java.util.List;

public class ExchangeRepository {

    private static ExchangeRepository instance;

    public ExchangeRateDTO save(ExchangeRateDTO exchangeRateDTO) {
        DynamoDBHandler.getInstance().getDynamoDBMapper().save(exchangeRateDTO);
        return exchangeRateDTO;
    }

    public List<ExchangeRateDTO> batchSave(List<ExchangeRateDTO> exchangeRates) {
        DynamoDBHandler.getInstance().getDynamoDBMapper().batchSave(exchangeRates);
        return exchangeRates;
    }

    public ExchangeRateDTO getExchangeRateDynamoById(String exchangeRateDynamoId) {
        return DynamoDBHandler.getInstance().getDynamoDBMapper().load(ExchangeRateDTO.class, exchangeRateDynamoId);
    }

    public PaginatedQueryList<ExchangeRateDTO> findByExchangeDate(String exchangeDateHashKey) {
        ExchangeRateDTO exchangeRateDTO = new ExchangeRateDTO();
        exchangeRateDTO.setExchangeDate(exchangeDateHashKey);

        DynamoDBQueryExpression<ExchangeRateDTO> queryExpression = new DynamoDBQueryExpression<ExchangeRateDTO>().withHashKeyValues(
                exchangeRateDTO);

        return DynamoDBHandler.getInstance().getDynamoDBMapper().query(ExchangeRateDTO.class, queryExpression);
    }

    public static synchronized ExchangeRepository getInstance() {
        if (instance == null) {
            instance = new ExchangeRepository();
        }
        return instance;
    }
}
