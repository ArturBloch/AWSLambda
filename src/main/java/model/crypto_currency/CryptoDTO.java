package model.crypto_currency;

import java.util.ArrayList;
import java.util.List;

public class CryptoDTO {
	private int id;
	private String name;
	private String symbol;
	private String lastUpdated;
	private List<CryptoExchangeDTO> exchanges = new ArrayList<>();

	public CryptoDTO(int id, String name, String symbol, String lastUpdated, List<CryptoExchangeDTO> exchanges) {
		this.id           = id;
		this.name         = name;
		this.symbol       = symbol;
		this.lastUpdated = lastUpdated;
		this.exchanges    = exchanges;
	}

	public CryptoDTO() {
	}

	public CryptoDTO(int id, String name, String symbol, String lastUpdated) {
		this.id           = id;
		this.name         = name;
		this.symbol       = symbol;
		this.lastUpdated = lastUpdated;
	}

	public int getId() {
		return id;
	}

	public CryptoDTO setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public CryptoDTO setName(String name) {
		this.name = name;
		return this;
	}

	public String getSymbol() {
		return symbol;
	}

	public CryptoDTO setSymbol(String symbol) {
		this.symbol = symbol;
		return this;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public CryptoDTO setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
		return this;
	}

	public List<CryptoExchangeDTO> getExchanges() {
		return exchanges;
	}

	public CryptoDTO setExchanges(List<CryptoExchangeDTO> exchanges) {
		this.exchanges = exchanges;
		return this;
	}
}
