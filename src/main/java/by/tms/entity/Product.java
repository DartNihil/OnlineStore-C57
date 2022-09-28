package by.tms.entity;

public abstract class Product {
    private String srcPicture;
    private String productName;
    private String producer;
    private String releaseDate;
    private String screenSize;
    private String color;
    private String operatingSystem;
    private String batteryCapacity;

    public Product() {
    }

    public Product(String srcPicture, String productName, String producer, String releaseDate, String screenSize, String color, String operatingSystem,
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
}
