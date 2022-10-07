package by.tms.storage;

import by.tms.entity.abstractProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component("inMemoryProductStorage")
public class ImMemoryProductStorage implements Storage<abstractProduct, Long> {
    private final List<abstractProduct> productList = new ArrayList<>();

    private final AtomicLong productIdGenerator = new AtomicLong(0);

    @Override
    public abstractProduct save(abstractProduct entity) {
        entity.setId(productIdGenerator.incrementAndGet());
        productList.add(entity);
        return null;
    }

    @Override
    public Optional<abstractProduct> findById(Long id) {
        for (abstractProduct product : productList) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<abstractProduct> getListOfEntity() {
        return productList;
    }

    @Override
    public Optional<abstractProduct> findEntity(String producer) {
        for (abstractProduct product : productList) {
            if (product.getProducer().equals(producer)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }


}
