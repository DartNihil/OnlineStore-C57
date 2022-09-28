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

    @Override
    public String toString() {
        return "Smartphone{" +
                "simCardFormat='" + simCardFormat + '\'' +
                ", srcPicture='" + this.getSrcPicture() + '\'' +
                ", productName='" + this.getProductName() + '\'' +
                ", producer='" + this.getProducer() + '\'' +
                ", releaseDate='" + this.getReleaseDate() + '\'' +
                ", screenSize='" + this.getScreenSize() + '\'' +
                ", color='" + this.getColor() + '\'' +
                ", operatingSystem='" + this.getOperatingSystem() + '\'' +
                ", batteryCapacity='" + this.getBatteryCapacity() + '\'' +
                '}';
    }
}
