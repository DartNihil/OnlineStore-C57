package by.tms.service;

import by.tms.entity.AbstractProduct;
import by.tms.entity.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class SearchProductService {
    @Autowired
    ProductService productService;

    public List<AbstractProduct> findByFilter(Filter filter) {

        return productService.getAbstractProductList()
                .stream()
                .filter(abstractProduct -> checkProducers(filter, abstractProduct))
                .filter(abstractProduct -> checkReleaseDates(filter, abstractProduct))
                .filter(abstractProduct -> checkScreenSizes(filter, abstractProduct))
                .filter(abstractProduct -> checkColors(filter, abstractProduct))
                .filter(abstractProduct -> checkOperatingSystems(filter, abstractProduct))
                .filter(abstractProduct -> checkBatteryCapacities(filter, abstractProduct))
                .collect(Collectors.toList());
    }

    private boolean checkProducers(Filter filter, AbstractProduct abstractProduct) {
        if (filter.getProducers() != null) {
            return filter.getProducers().contains(abstractProduct.getProducer());
        }
        return true;
    }

    private boolean checkReleaseDates(Filter filter, AbstractProduct abstractProduct) {
        if (filter.getReleaseDates() != null) {
            return filter.getProducers().contains(abstractProduct.getReleaseDate());
        }
        return true;
    }

    private boolean checkScreenSizes(Filter filter, AbstractProduct abstractProduct) {
        if (filter.getScreenSizes() != null) {
            return filter.getProducers().contains(abstractProduct.getScreenSize());
        }
        return true;
    }

    private boolean checkColors(Filter filter, AbstractProduct abstractProduct) {
        if (filter.getColors() != null) {
            return filter.getProducers().contains(abstractProduct.getColor());
        }
        return true;
    }

    private boolean checkOperatingSystems(Filter filter, AbstractProduct abstractProduct) {
        if (filter.getOperatingSystems() != null) {
            return filter.getProducers().contains(abstractProduct.getOperatingSystem());
        }
        return true;
    }

    private boolean checkBatteryCapacities(Filter filter, AbstractProduct abstractProduct) {
        if (filter.getBatteryCapacities() != null) {
            return filter.getProducers().contains(abstractProduct.getBatteryCapacity());
        }
        return true;
    }
}