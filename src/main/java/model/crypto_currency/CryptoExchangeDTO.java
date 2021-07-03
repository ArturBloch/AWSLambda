package model.crypto_currency;

import java.math.BigDecimal;

public class CryptoExchangeDTO {
	private String currencyName;
	private BigDecimal exchangeValue;
	private String percentChange1H;
	private String percentChange24H;

	public CryptoExchangeDTO() {
	}

	public CryptoExchangeDTO(String currencyName, String exchangeValue, String percentChange1H, String percentChange24H) {
		this.currencyName       = currencyName;
		this.exchangeValue      = new BigDecimal(exchangeValue);
		this.percentChange1H = percentChange1H;
		this.percentChange24H = percentChange24H;
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

	public String getPercentChange1H() {
		return percentChange1H;
	}

	public CryptoExchangeDTO setPercentChange1H(String percentChange1H) {
		this.percentChange1H = percentChange1H;
		return this;
	}

	public String getPercentChange24H() {
		return percentChange24H;
	}

	public CryptoExchangeDTO setPercentChange24H(String percentChange24H) {
		this.percentChange24H = percentChange24H;
		return this;
	}
}
