package by.tms.storage;

import by.tms.entity.Customer;
import by.tms.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component("inMemoryProductStorage")
public class ImMemoryProductStorage implements Storage<Product, Long> {
    private final List<Product> productList = new ArrayList<>();

    private final AtomicLong productIdGenerator = new AtomicLong(0);

    @Override
    public Product save(Product entity) {
        entity.setId(productIdGenerator.incrementAndGet());
        productList.add(entity);
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Product> getListOfEntity() {
        return productList;
    }

    @Override
    public Optional<Product> findEntity(String producer) {
        for (Product product : productList) {
            if (product.getProducer().equals(producer)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }


}
