package by.tms.storage;

import by.tms.Properties;
import by.tms.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class JdbcCustomerStorage implements Storage<Customer, Long> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCustomerStorage(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final List<Customer> customerList = new ArrayList<>();
    private final AtomicLong customerIdGenerator = new AtomicLong(0);


    @Override
    public Customer save(Customer customer) {
        customer.setId(customerIdGenerator.incrementAndGet());
        jdbcTemplate.update( "INSERT INTO customers2 VALUES (?, ?, ?, ?, ?)",
                customer.getFirstname(),
                customer.getLastname(),
                customer.getNickname(),
                customer.getPassword(),
                customer.getEmail());
        return customer;
    }

    public void update(long id, Customer updatedCustomer){
        jdbcTemplate.update("UPDATE customers2 SET firstname=?, lastname=?, nickname=?, email=?, password=? WHERE id=?",
                updatedCustomer.getFirstname(),
                updatedCustomer.getLastname(),
                updatedCustomer.getNickname(),
                updatedCustomer.getEmail(),
                updatedCustomer.getPassword());
    }

    public void delete(long id){
        jdbcTemplate.update("DELETE FROM customers2 WHERE id=?", id);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM customers2 WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Customer.class))
                .stream().findAny();
    }

    @Override
    public List<Customer> getListOfEntity() {
        return jdbcTemplate.query("Select * from customers2", new BeanPropertyRowMapper<>(Customer.class));
    }

    @Override
    public Optional<Customer> findEntity(String email) {
        return jdbcTemplate.query("SELECT * FROM customers2 WHERE email=?", new Object[]{email}, new BeanPropertyRowMapper<>(Customer.class))
                .stream().findAny();
    }
}
