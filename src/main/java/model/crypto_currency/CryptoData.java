package model.crypto_currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoData {
	private int id;
	private String name;
	private String symbol;
	private String lastUpdated;
	private int cmcRank;
	private Map<String, ValueModel> quote;

	public CryptoData() {
	}

	public int getId() {
		return id;
	}

	public CryptoData setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public CryptoData setName(String name) {
		this.name = name;
		return this;
	}

	public String getSymbol() {
		return symbol;
	}

	public CryptoData setSymbol(String symbol) {
		this.symbol = symbol;
		return this;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public CryptoData setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
		return this;
	}

	public int getCmcRank() {
		return cmcRank;
	}

	public CryptoData setCmcRank(int cmcRank) {
		this.cmcRank = cmcRank;
		return this;
	}

	public Map<String, ValueModel> getQuote() {
		return quote;
	}

	public CryptoData setQuote(Map<String, ValueModel> quote) {
		this.quote = quote;
		return this;
	}
}
