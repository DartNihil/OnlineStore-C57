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
    private Storage<AbstractProduct, Long> productStorage;

    public AbstractProduct saveProduct(AbstractProduct product) {
        productStorage.save(product);
        return product;
    }

    public Optional<AbstractProduct> findProductByProducer(String producer) {
        return productStorage.findEntity(producer);
    }
    public Optional<AbstractProduct> findProductById(Long id) {
        return productStorage.findById(id);
    }
    public List<AbstractProduct> getProductListForStoreOffer(String productCategory) {
        fillProductListToTest();
        List<AbstractProduct> productList = null;
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
        saveProduct(new Smartphone("111", "Iphone1", "Apple", "2022", "123size", "black", "IOS", "12345", "nano"));
        saveProduct(new Tablet("444", "Ipad1", "Apple", "2022", "444size", "black", "IOS", "12345", "98752"));
        saveProduct(new Smartphone("222", "Iphone2", "Apple", "2021", "222size", "black", "IOS", "1234", "nano"));
        saveProduct(new Notebook("555", "Macbook2", "Apple", "2022", "555size", "black", "IOS", "4321", "ssd"));
        saveProduct(new Smartphone("333", "Iphone3", "Apple", "2020", "333size", "black", "IOS", "123", "nano"));
        saveProduct(new ElectronicBook("666", "EBook1", "TextB", "2020", "666size", "black", "Android", "666", "txt"));
        saveProduct(new Smartwatch("777", "SWatch1", "Huawei", "2022", "777size", "black", "Android", "777", "leather"));
    }

    private List<AbstractProduct> getSmartphoneList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof Smartphone).toList();
    }

    private List<AbstractProduct> getSmartwatchList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof Smartwatch).toList();
    }

    private List<AbstractProduct> getElectronicBookList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof ElectronicBook).toList();
    }

    private List<AbstractProduct> getTabletList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof Tablet).toList();
    }

    private List<AbstractProduct> getNotebookList() {
        return productStorage.getListOfEntity().stream().filter(product ->
                product instanceof Notebook).toList();
    }
}
