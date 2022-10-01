package by.tms.entity;

public class Smartwatch extends Product {
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
