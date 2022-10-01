package by.tms.entity;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

public class Store extends User {
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

    public Store() {
    }

    public Store(long id, String email, String password, String storeName, String storePhoneNumber, String storeAddress, String storeOpeningHours, List<String> productCategories, List<String> paymentMethods) {
        super(id, email, password);
        this.storeName = storeName;
        this.storePhoneNumber = storePhoneNumber;
        this.storeAddress = storeAddress;
        this.storeOpeningHours = storeOpeningHours;
        this.productCategories = productCategories;
        this.paymentMethods = paymentMethods;
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

    public String getStoreOpeningHours() {
        return storeOpeningHours;
    }

    public void setStoreOpeningHours(String storeOpeningHours) {
        this.storeOpeningHours = storeOpeningHours;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public List<String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<String> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public List<String> getProductCategories() {
        return productCategories;
    }

    public void setProductCategories(List<String> productCategories) {
        this.productCategories = productCategories;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeName='" + storeName + '\'' +
                ", storePhoneNumber='" + storePhoneNumber + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeOpeningHours='" + storeOpeningHours + '\'' +
                ", productCategories=" + productCategories +
                ", paymentMethods=" + paymentMethods +
                ", email='" + this.getEmail() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                ", id='" + this.getId() + '\'' +
                '}';
    }
}
