package by.tms.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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
    private List<String> productCategories;
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Payer account number length must be 9!", min = 9, max = 9)
    @Pattern(message = "Payer account number is incorrect!", regexp = "[\\d]+")
    private String payerAccountNumber;
    @NotBlank(message = "Field must not be empty")
    @Size(message = "Registration certificate length must be 2 - 60", min = 2, max = 60)
    private String registrationCertificate;
    private List<String> paymentMethods;

    public Store() {
    }

    public Store(String storeName, String storePhoneNumber, String storeAddress, String storeOpeningHours,
                 List<String> productCategories, String payerAccountNumber, String registrationCertificate,
                 List<String> paymentMethods) {
        this.storeName = storeName;
        this.storePhoneNumber = storePhoneNumber;
        this.storeAddress = storeAddress;
        this.storeOpeningHours = storeOpeningHours;
        this.productCategories = productCategories;
        this.payerAccountNumber = payerAccountNumber;
        this.registrationCertificate = registrationCertificate;
        this.paymentMethods = paymentMethods;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPayerAccountNumber() {
        return payerAccountNumber;
    }

    public void setPayerAccountNumber(String payerAccountNumber) {
        this.payerAccountNumber = payerAccountNumber;
    }

    public String getRegistrationCertificate() {
        return registrationCertificate;
    }

    public void setRegistrationCertificate(String registrationCertificate) {
        this.registrationCertificate = registrationCertificate;
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
                ", payerAccountNumber='" + payerAccountNumber + '\'' +
                ", registrationCertificate='" + registrationCertificate + '\'' +
                ", paymentMethods=" + paymentMethods +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", id=" + id +
                '}';
    }
}
