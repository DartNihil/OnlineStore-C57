package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Smartwatch extends Product {
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Bracelet material length must be more then 2", min = 2)
    private String braceletMaterial;

    public Smartwatch() {
    }

    public Smartwatch(String srcPicture, String productName, String producer, String releaseDate, String screenSize, String color, String operatingSystem,
                      String batteryCapacity, String braceletMaterial) {
        super(srcPicture, productName, producer, releaseDate, screenSize, color, operatingSystem, batteryCapacity);
        this.braceletMaterial = braceletMaterial;
    }

    public String getBraceletMaterial() {
        return braceletMaterial;
    }

    public void setBraceletMaterial(String braceletMaterial) {
        this.braceletMaterial = braceletMaterial;
    }
}
