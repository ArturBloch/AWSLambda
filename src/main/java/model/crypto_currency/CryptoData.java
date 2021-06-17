package model.crypto_currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoData {
	public int id;
	public String name;
	public String symbol;
	public String last_updated;
	public int cmc_rank;
	public HashMap<String, ValueModel> quote;

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

	public String getLast_updated() {
		return last_updated;
	}

	public CryptoData setLast_updated(String last_updated) {
		this.last_updated = last_updated;
		return this;
	}

	public int getCmc_rank() {
		return cmc_rank;
	}

	public CryptoData setCmc_rank(int cmc_rank) {
		this.cmc_rank = cmc_rank;
		return this;
	}

	public HashMap<String, ValueModel> getQuote() {
		return quote;
	}

	public CryptoData setQuote(HashMap<String, ValueModel> quote) {
		this.quote = quote;
		return this;
	}
}
