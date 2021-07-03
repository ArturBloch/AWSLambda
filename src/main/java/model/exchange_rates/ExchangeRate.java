package model.exchange_rates;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {

	private String base;
	private long timestamp;
	private Map<String, BigDecimal> rates = new HashMap<>();

	public ExchangeRate() {
	}

	public ExchangeRate(String base, long timestamp) {
		this.base      = base;
		this.timestamp = timestamp;
	}

	public ExchangeRate(String base, long timestamp, Map<String, BigDecimal> rates) {
		this.base      = base;
		this.timestamp = timestamp;
		this.rates     = rates;
	}

	public String getBase() {
		return base;
	}

	public ExchangeRate setBase(String base) {
		this.base = base;
		return this;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public ExchangeRate setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		return this;
	}

	public Map<String, BigDecimal> getRates() {
		return rates;
	}

	public ExchangeRate setRates(Map<String, BigDecimal> rates) {
		this.rates = rates;
		return this;
	}
}
