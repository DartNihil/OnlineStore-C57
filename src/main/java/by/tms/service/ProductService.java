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
        return productStorage.findEntity(producer);
    }

    public Optional<Product> findProductById(Long id) {
        return productStorage.findById(id);
    }

    public List<Product> getProductListForStoreOffer(String productCategory) {
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

    public String getPageNameForProductToOffer(String productCategory) {
        return "storeOffer/select" + productCategory;
    }

    public String getPageNameForProductToAdmin(String productCategory) {
        return "redirect:/admin/add" + productCategory;
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
