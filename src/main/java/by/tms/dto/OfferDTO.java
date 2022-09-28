package by.tms.dto;

import java.math.BigDecimal;

public class OfferDTO {
    private String description;
    private BigDecimal price;

    public OfferDTO(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
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
}
