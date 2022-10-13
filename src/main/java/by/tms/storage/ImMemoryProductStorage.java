package by.tms.storage;

import by.tms.entity.AbstractProduct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component("inMemoryProductStorage")
public class ImMemoryProductStorage implements Storage<AbstractProduct, Long> {
    private final List<AbstractProduct> productList = new ArrayList<>();

    private final AtomicLong productIdGenerator = new AtomicLong(0);

    @Override
    public AbstractProduct save(AbstractProduct entity) {
        entity.setId(productIdGenerator.incrementAndGet());
        productList.add(entity);
        return null;
    }

    @Override
    public Optional<AbstractProduct> findById(Long id) {
        for (AbstractProduct product : productList) {
            if (product.getId() == id) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }

    @Override
    public AbstractProduct delete(AbstractProduct entity) {
        return null;
    }

    @Override
    public List<AbstractProduct> getListOfEntity() {
        return productList;
    }

    @Override
    public Optional<AbstractProduct> findEntity(String producer) {
        for (AbstractProduct product : productList) {
            if (product.getProducer().equals(producer)) {
                return Optional.of(product);
            }
        }
        return Optional.empty();
    }
}
