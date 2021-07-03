package model.crypto_currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CryptoRequest {
	private List<CryptoData> data = new ArrayList<>();

	public CryptoRequest() {
	}

	public List<CryptoData> getData() {
		return data;
	}

	public CryptoRequest setData(List<CryptoData> data) {
		this.data = data;
		return this;
	}
}
