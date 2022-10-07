package by.tms.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Offer extends abstractEntity {
    private LocalDateTime offerDateTime;
    private abstractProduct product;
    private String description;
    private BigDecimal price;
    private Store store;

    public Offer() {
        this.offerDateTime = LocalDateTime.now();
    }

    public Offer(LocalDateTime offerDateTime, abstractProduct product, String description, BigDecimal price, Store store) {
        this.offerDateTime = offerDateTime;
        this.product = product;
        this.description = description;
        this.price = price;
        this.store = store;
    }

    public LocalDateTime getOfferDateTime() {
        return offerDateTime;
    }

    public void setOfferDateTime(LocalDateTime offerDateTime) {
        this.offerDateTime = offerDateTime;
    }

    public abstractProduct getProduct() {
        return product;
    }

    public void setProduct(abstractProduct product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "offerDateTime=" + offerDateTime +
                ", product=" + product +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", store=" + store +
                '}';
    }
}
