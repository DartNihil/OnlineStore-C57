package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public abstract class abstractProduct extends abstractEntity {
    @NotBlank(message = "Field must not be empty")
    @Pattern(message = "Must be src link", regexp = "https:.+\\.[\\w]{3,4}")
    private String srcPicture;
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Product name length must be more then 2", min = 2)
    private String productName;
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Producer length must be more then 2", min = 2)
    private String producer;

    @Pattern(message = "Must be year of release", regexp = "\\d+")
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Must be year of release", min = 4, max = 4)
    private String releaseDate;
    @NotBlank(message = "Field must not be empty")
    @Size(message = "screenSize length must be more then 2", min = 2)
    private String screenSize;
    @NotBlank(message = "Field must not be empty")
    @Pattern(message = "Must be letters", regexp = "\\w+")
    @Size(message = "color length must be more then 2", min = 2)
    private String color;
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Operating system length must be more then 2", min = 2)
    private String operatingSystem;
    @NotBlank(message = "Field must not be empty")
    @Pattern(message = "Must be numbers", regexp = "\\d+")
    @Size(message = "Battery capacity length must be more then 2", min = 2)
    private String batteryCapacity;

    public abstractProduct() {
    }

    public abstractProduct(String srcPicture, String productName, String producer, String releaseDate, String screenSize, String color, String operatingSystem,
                           String batteryCapacity) {
        this.srcPicture = srcPicture;
        this.productName = productName;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.screenSize = screenSize;
        this.color = color;
        this.operatingSystem = operatingSystem;
        this.batteryCapacity = batteryCapacity;
    }

    public String getSrcPicture() {
        return srcPicture;
    }

    public void setSrcPicture(String srcPicture) {
        this.srcPicture = srcPicture;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + this.getId() + '\'' +
                ", srcPicture='" + srcPicture + '\'' +
                ", productName='" + productName + '\'' +
                ", producer='" + producer + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", screenSize='" + screenSize + '\'' +
                ", color='" + color + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", batteryCapacity='" + batteryCapacity + '\'' +
                '}';
    }
}