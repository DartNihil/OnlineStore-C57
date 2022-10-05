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
    private Storage<Product, Long> productStorage;

    public Product saveProduct(Product product) {
        productStorage.save(product);
        return product;
    }

    public Optional<Product> findProductByProducer(String producer) {
        Optional<Product> product = productStorage.findEntity(producer);
        return product;
    }

    public List<Product> getProductListForStoreOffer(String productCategory) {
        fillProductListToTest();
        List<Product> productList = null;
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

    //method to test
    private void fillProductListToTest() {
        saveProduct(new Smartphone("111", "Iphone1", "Apple", "2022", "123size", "black", "IOS", "12345", "nano"));
        saveProduct(new Tablet("444", "Ipad1", "Apple", "2022", "444size", "black", "IOS", "12345", "98752"));
        saveProduct(new Smartphone("222", "Iphone2", "Apple", "2021", "222size", "black", "IOS", "1234", "nano"));
        saveProduct(new Notebook("555", "Macbook2", "Apple", "2022", "555size", "black", "IOS", "4321", "ssd"));
        saveProduct(new Smartphone("333", "Iphone3", "Apple", "2020", "333size", "black", "IOS", "123", "nano"));
        saveProduct(new ElectronicBook("666", "EBook1", "TextB", "2020", "666size", "black", "Android", "666", "txt"));
        saveProduct(new Smartwatch("777", "SWatch1", "Huawei", "2022", "777size", "black", "Android", "777", "leather"));
    }

    private List<Product> getSmartphoneList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof Smartphone).toList();
    }

    private List<Product> getSmartwatchList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof Smartwatch).toList();
    }

    private List<Product> getElectronicBookList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof ElectronicBook).toList();
    }

    private List<Product> getTabletList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof Tablet).toList();
    }

    private List<Product> getNotebookList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof Notebook).toList();
    }
}
