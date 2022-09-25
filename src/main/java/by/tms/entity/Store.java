package by.tms.entity;

public class Store extends Entity {
    private String email;
    private String password;
    private String storeName;
    private String phoneNumber;
    private String storeAddress;
    private String payerAccountNumber;
    private String registrationCertificate;

    public Store() {
    }

    public Store(String email, String password, String storeName, String phoneNumber,
                 String storeAddress, String payerAccountNumber, String registrationCertificate) {
        this.email = email;
        this.password = password;
        this.storeName = storeName;
        this.phoneNumber = phoneNumber;
        this.storeAddress = storeAddress;
        this.payerAccountNumber = payerAccountNumber;
        this.registrationCertificate = registrationCertificate;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
//    public StoreBuilder builder(){
//        return new StoreBuilder();
//    }
//     public static class StoreBuilder {
//         private String email;
//         private String password;
//         private String storeName;
//         private String phoneNumber;
//         private String storeAddress;
//         private String payerAccountNumber;
//         private String registrationCertificate;
//
//         public StoreBuilder() {
//         }
//         public StoreBuilder email(String email) {
//             this.email = email;
//             return this;
//         }
//         public StoreBuilder password(String password) {
//             this.password = password;
//             return this;
//         }
//         public StoreBuilder storeName(String storeName) {
//             this.storeName = storeName;
//             return this;
//         }
//         public StoreBuilder phoneNumber(String phoneNumber) {
//             this.phoneNumber = phoneNumber;
//             return this;
//         }
//         public StoreBuilder storeAddress(String storeAddress) {
//             this.storeAddress = storeAddress;
//             return this;
//         }
//         public StoreBuilder payerAccountNumber(String payerAccountNumber) {
//             this.payerAccountNumber = payerAccountNumber;
//             return this;
//         }
//         public StoreBuilder registrationCertificate(String registrationCertificate) {
//             this.registrationCertificate = registrationCertificate;
//             return this;
//         }
//         public Store build() {
//             return new Store(this.email, this.password, this.storeName, this.phoneNumber,
//                     this.storeAddress, this.payerAccountNumber, this.registrationCertificate);
//         }
//
//     }
}
