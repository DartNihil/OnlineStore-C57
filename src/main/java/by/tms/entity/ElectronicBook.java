package by.tms.entity;

public class ElectronicBook extends Product {
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
