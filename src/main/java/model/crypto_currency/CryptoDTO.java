package model.crypto_currency;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CryptoDTO {
	public int id;
	public String name;
	public String symbol;
	public String last_updated;
	public List<CryptoExchangeDTO> exchanges = new ArrayList<>();

	public CryptoDTO(int id, String name, String symbol, String last_updated, List<CryptoExchangeDTO> exchanges) {
		this.id           = id;
		this.name         = name;
		this.symbol       = symbol;
		this.last_updated = last_updated;
		this.exchanges    = exchanges;
	}

	public CryptoDTO() {
	}

	public CryptoDTO(int id, String name, String symbol, String last_updated) {
		this.id           = id;
		this.name         = name;
		this.symbol       = symbol;
		this.last_updated = last_updated;
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

	public String getLast_updated() {
		return last_updated;
	}

	public CryptoDTO setLast_updated(String last_updated) {
		this.last_updated = last_updated;
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
