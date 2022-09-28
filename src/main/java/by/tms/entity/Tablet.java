package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Tablet extends Product {
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Screen ratio length must be more then 2", min = 2)
    private String screenRatio;

    public Tablet() {
    }

    public Tablet(String srcPicture, String productName, String producer, String releaseDate, String screenSize, String color, String operatingSystem,
                  String batteryCapacity, String screenRatio) {
        super(srcPicture, productName, producer, releaseDate, screenSize, color, operatingSystem, batteryCapacity);
        this.screenRatio = screenRatio;
    }

    public String getScreenRatio() {
        return screenRatio;
    }

    public void setScreenRatio(String screenRatio) {
        this.screenRatio = screenRatio;
    }
}
