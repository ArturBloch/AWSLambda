package model.crypto_currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueModel {
	String price;
	String volume_24h;
	String percent_change_1h;
	String percent_change_24h;
	String percent_change_7d;
	String market_cap;
	String last_updated;

	public ValueModel() {
	}

	public String getPrice() {
		return price;
	}

	public ValueModel setPrice(String price) {
		this.price = price;
		return this;
	}

	public String getVolume_24h() {
		return volume_24h;
	}

	public ValueModel setVolume_24h(String volume_24h) {
		this.volume_24h = volume_24h;
		return this;
	}

	public String getPercent_change_1h() {
		return percent_change_1h;
	}

	public ValueModel setPercent_change_1h(String percent_change_1h) {
		this.percent_change_1h = percent_change_1h;
		return this;
	}

	public String getPercent_change_24h() {
		return percent_change_24h;
	}

	public ValueModel setPercent_change_24h(String percent_change_24h) {
		this.percent_change_24h = percent_change_24h;
		return this;
	}

	public String getPercent_change_7d() {
		return percent_change_7d;
	}

	public ValueModel setPercent_change_7d(String percent_change_7d) {
		this.percent_change_7d = percent_change_7d;
		return this;
	}

	public String getMarket_cap() {
		return market_cap;
	}

	public ValueModel setMarket_cap(String market_cap) {
		this.market_cap = market_cap;
		return this;
	}

	public String getLast_updated() {
		return last_updated;
	}

	public ValueModel setLast_updated(String last_updated) {
		this.last_updated = last_updated;
		return this;
	}
}
