package by.tms.entity;

public class Tablet extends Product {
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
