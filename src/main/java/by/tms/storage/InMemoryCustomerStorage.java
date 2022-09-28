package by.tms.storage;

import by.tms.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component("inMemoryCustomerStorage")
public class InMemoryCustomerStorage implements Storage<Customer, Long> {

    private final List<Customer> customerList = new ArrayList<>();

    private final AtomicLong customerIdGenerator = new AtomicLong(0);

    @Override
    public Customer save(Customer customer) {
        customer.setId(customerIdGenerator.incrementAndGet());
        customerList.add(customer);
        return customer;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Customer> getListOfEntity() {
        return customerList;
    }

    @Override
    public Optional<Customer> findEntity(String email) {
        for (Customer customer : customerList) {
            if (customer.getEmail().equals(email)) {
                return Optional.of(customer);
            }
        }
        return Optional.empty();
    }
}
