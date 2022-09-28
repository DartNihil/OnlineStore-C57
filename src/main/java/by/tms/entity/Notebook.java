package by.tms.entity;

public class Notebook extends Product {
    private String hardDiskDriveType;

    public Notebook() {
    }

    public Notebook(String srcPicture, String productName, String producer, String releaseDate, String screenSize, String color, String operatingSystem,
                    String batteryCapacity, String hardDiskDriveType) {
        super(srcPicture, productName, producer, releaseDate, screenSize, color, operatingSystem, batteryCapacity);
        this.hardDiskDriveType = hardDiskDriveType;
    }

    public String getHardDiskDriveType() {
        return hardDiskDriveType;
    }

    public void setHardDiskDriveType(String hardDiskDriveType) {
        this.hardDiskDriveType = hardDiskDriveType;
    }
}
