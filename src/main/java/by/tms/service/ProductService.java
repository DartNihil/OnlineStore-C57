package by.tms.service;

import by.tms.entity.*;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductService {
    @Autowired
    @Qualifier("inMemoryProductStorage")
    private Storage<abstractProduct, Long> productStorage;

    public abstractProduct saveProduct(abstractProduct product) {
        productStorage.save(product);
        return product;
    }

    public Optional<abstractProduct> findProductByProducer(String producer) {
        return productStorage.findEntity(producer);
    }
    public Optional<abstractProduct> findProductById(Long id) {
        return productStorage.findById(id);
    }
    public List<abstractProduct> getProductListForStoreOffer(String productCategory) {
        if(productStorage.getListOfEntity().isEmpty()) {
            fillProductListToTest();
        }
        List<abstractProduct> productList = null;
        switch (productCategory) {
            case ("Smartphone"):
                productList = getSmartphoneList();
                break;
            case ("Tablet"):
                productList = getTabletList();
                break;
            case ("Notebook"):
                productList = getNotebookList();
                break;
            case ("ElectronicBook"):
                productList = getElectronicBookList();
                break;
            case ("Smartwatch"):
                productList = getSmartwatchList();
                break;
            default:
                break;
        }
        return productList;
    }
    public String getPageNameForProduct(String productCategory) {
        return "storeOffer/select" + productCategory;
    }

    //method to test
    private void fillProductListToTest() {
        saveProduct(new Smartphone("https://s.ek.ua/jpg_zoom1/1652336.jpg", "Iphone1", "Apple", "2022", "123size", "black", "IOS", "12345", "nano"));
        saveProduct(new Tablet("https://shop.mts.by/upload/resize_cache/webp/iblock/ba3/600_900_1/Tab-A7-Lite-LTE-seryy.webp", "Ipad1", "Apple", "2022", "444size", "black", "IOS", "12345", "98752"));
        saveProduct(new Smartphone("https://ichip.ru/blobimgs/uploads/2018/11/Xiaomi-Redmi-6.jpg", "Iphone2", "Apple", "2021", "222size", "black", "IOS", "1234", "nano"));
        saveProduct(new Notebook("https://ixbt.online/live/images/original/20/28/05/2022/02/08/d391eccc07.jpg?w=877", "Macbook2", "Apple", "2022", "555size", "black", "IOS", "4321", "ssd"));
        saveProduct(new Smartphone("https://5element.by/upload/medialibrary/64c/64c95e8e16da273ff37cd536c1b390b5.jpg", "Iphone3", "Apple", "2020", "333size", "black", "IOS", "123", "nano"));
        saveProduct(new ElectronicBook("https://f.ua/statik/images/products/250/amazon/kindle_paperwhite_6_8gb_10_gen_2020_blue_877425764180.jpg", "EBook1", "TextB", "2020", "666size", "black", "Android", "666", "txt"));
        saveProduct(new Smartwatch("https://m.sila.by/img/catalog2015/img10/tovar104161.jpg", "SWatch1", "Huawei", "2022", "777size", "black", "Android", "777", "leather"));
    }

    private List<abstractProduct> getSmartphoneList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof Smartphone).toList();
    }

    private List<abstractProduct> getSmartwatchList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof Smartwatch).toList();
    }

    private List<abstractProduct> getElectronicBookList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof ElectronicBook).toList();
    }

    private List<abstractProduct> getTabletList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof Tablet).toList();
    }

    private List<abstractProduct> getNotebookList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof Notebook).toList();
    }
}
