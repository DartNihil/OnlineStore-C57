package by.tms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class OfferDTO {
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Description length must be more then 2", min = 2)
    private String description;
    @NotBlank(message = "Field must not be empty")
    @Pattern(message = "Prise must be in format ***.**!", regexp = "[\\d]+\\.[\\d]{2}")
    private String price;

    public OfferDTO(String description, String price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
