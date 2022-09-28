package by.tms.entity;

public class Smartphone extends Product {
    private String simCardFormat;

    public Smartphone() {
    }

    public Smartphone(String srcPicture, String productName, String producer, String releaseDate, String screenSize, String color, String operatingSystem,
                      String batteryCapacity, String simCardFormat) {
        super(srcPicture, productName, producer, releaseDate, screenSize, color, operatingSystem, batteryCapacity);
        this.simCardFormat = simCardFormat;
    }

    public String getSimCardFormat() {
        return simCardFormat;
    }

    public void setSimCardFormat(String simCardFormat) {
        this.simCardFormat = simCardFormat;
    }
}
