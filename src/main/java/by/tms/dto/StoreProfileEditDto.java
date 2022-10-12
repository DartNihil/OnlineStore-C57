package by.tms.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StoreProfileEditDto {
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Store name length must be 2 - 16", min = 2, max = 16)
    private String storeName;
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Phone number has incorrect length!", min = 13, max = 13)
    @Pattern(message = "Phone number is incorrect!", regexp = "\\+375[\\d]+")
    private String storePhoneNumber;
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Store address length must be 2 - 150", min = 2, max = 150)
    private String storeAddress;
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Store opening hours length must be 2 - 60", min = 2, max = 60)
    private String storeOpeningHours;
    @NotNull
    @Size(min = 1, max = 5)
    private List<String> productCategories;
    @NotNull
    @Size(min = 1, max = 3)
    private List<String> paymentMethods;
    @NotNull
    @Size(min = 1 , max = 3)
    private List<String> deliveryMethods;

    public StoreProfileEditDto(String storeName, String storePhoneNumber, String storeAddress, String storeOpeningHours, List<String> productCategories, List<String> paymentMethods, List<String> deliveryMethods) {
        this.storeName = storeName;
        this.storePhoneNumber = storePhoneNumber;
        this.storeAddress = storeAddress;
        this.storeOpeningHours = storeOpeningHours;
        this.productCategories = productCategories;
        this.paymentMethods = paymentMethods;
        this.deliveryMethods = deliveryMethods;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStorePhoneNumber() {
        return storePhoneNumber;
    }

    public void setStorePhoneNumber(String storePhoneNumber) {
        this.storePhoneNumber = storePhoneNumber;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getStoreOpeningHours() {
        return storeOpeningHours;
    }

    public void setStoreOpeningHours(String storeOpeningHours) {
        this.storeOpeningHours = storeOpeningHours;
    }

    public List<String> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<String> productCategories) {
        this.productCategories = productCategories;
    }

    public List<String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public List<String> getDeliveryMethods() {
        return deliveryMethods;
    }

    public void setDeliveryMethods(List<String> deliveryMethods) {
        this.deliveryMethods = deliveryMethods;
    }
}
