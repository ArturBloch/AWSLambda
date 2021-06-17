package model.crypto_currency;

import java.math.BigDecimal;

public class CryptoExchangeDTO {
	String currencyName;
	BigDecimal exchangeValue;
	String percent_change_1h;
	String percent_change_24h;

	public CryptoExchangeDTO() {
	}

	public CryptoExchangeDTO(String currencyName, String exchangeValue, String percent_change_1h, String percent_change_24h) {
		this.currencyName       = currencyName;
		this.exchangeValue      = new BigDecimal(exchangeValue);
		this.percent_change_1h  = percent_change_1h;
		this.percent_change_24h = percent_change_24h;
	}

	public CryptoExchangeDTO(String currencyName, BigDecimal exchangeValue, String percent_change_1h, String percent_change_24h) {
		this.currencyName       = currencyName;
		this.exchangeValue      = exchangeValue;
		this.percent_change_1h  = percent_change_1h;
		this.percent_change_24h = percent_change_24h;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public CryptoExchangeDTO setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
		return this;
	}

	public BigDecimal getExchangeValue() {
		return exchangeValue;
	}

	public CryptoExchangeDTO setExchangeValue(BigDecimal exchangeValue) {
		this.exchangeValue = exchangeValue;
		return this;
	}

	public String getPercent_change_1h() {
		return percent_change_1h;
	}

	public CryptoExchangeDTO setPercent_change_1h(String percent_change_1h) {
		this.percent_change_1h = percent_change_1h;
		return this;
	}

	public String getPercent_change_24h() {
		return percent_change_24h;
	}

	public CryptoExchangeDTO setPercent_change_24h(String percent_change_24h) {
		this.percent_change_24h = percent_change_24h;
		return this;
	}
}
