package by.tms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class OfferDTO {
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Description length must be more then 2", min = 2)
    private String description;
    @NotBlank(message = "Field must not be empty")
    @Pattern(message = "Must be numbers", regexp = "\\d+")
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
