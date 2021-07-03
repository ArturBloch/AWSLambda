package model.crypto_currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueModel {
    String price;
    String volume24H;
    String percentChange1H;
    String percentChange24H;
    String percentChange7D;
    String marketCap;
    String lastUpdated;

    public ValueModel() {
    }

    public String getPrice() {
        return price;
    }

    public ValueModel setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getVolume24H() {
        return volume24H;
    }

    public ValueModel setVolume24H(String volume24H) {
        this.volume24H = volume24H;
        return this;
    }

    public String getPercentChange1H() {
        return percentChange1H;
    }

    public ValueModel setPercentChange1H(String percentChange1H) {
        this.percentChange1H = percentChange1H;
        return this;
    }

    public String getPercentChange24H() {
        return percentChange24H;
    }

    public ValueModel setPercentChange24H(String percentChange24H) {
        this.percentChange24H = percentChange24H;
        return this;
    }

    public String getPercentChange7D() {
        return percentChange7D;
    }

    public ValueModel setPercentChange7D(String percentChange7D) {
        this.percentChange7D = percentChange7D;
        return this;
    }

    public String getMarketCap() {
        return marketCap;
    }

    public ValueModel setMarketCap(String marketCap) {
        this.marketCap = marketCap;
        return this;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public ValueModel setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }
}
