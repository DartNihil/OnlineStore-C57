package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Smartphone extends Product {
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Sim card format length must be more then 2", min = 2)
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
