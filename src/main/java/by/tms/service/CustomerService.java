package by.tms.service;

import by.tms.entity.Customer;
import by.tms.storage.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    @Qualifier("inMemoryCustomerStorage")
    private Storage<Customer, Long> customerStorage;

    public Customer saveCustomer(Customer customer) {
        customerStorage.save(customer);
        return customer;
    }
    public Optional<Customer> findEntity(String email){
        return customerStorage.findEntity(email);
    }
}
