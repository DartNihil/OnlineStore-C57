package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ElectronicBook extends abstractProduct {

    @NotBlank(message = "Field must not be empty")
    @Size(message = "Text format length must be more then 2", min = 2)

    private String textFormat;

    public ElectronicBook() {
    }

    public ElectronicBook(String srcPicture, String productName, String producer, String releaseDate, String screenSize, String color, String operatingSystem,
                          String batteryCapacity, String textFormat) {
        super(srcPicture, productName, producer, releaseDate, screenSize, color, operatingSystem, batteryCapacity);
        this.textFormat = textFormat;
    }

    public String getTextFormat() {
        return textFormat;
    }

    public void setTextFormat(String textFormat) {
        this.textFormat = textFormat;
    }
}
