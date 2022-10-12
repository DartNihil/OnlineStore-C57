package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Notebook extends AbstractProduct {
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Hard disk drive type length must be more then 2", min = 2)
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