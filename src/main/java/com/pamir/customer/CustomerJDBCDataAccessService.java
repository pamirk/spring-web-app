package com.pamir.customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class CustomerJDBCDataAccessService implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;

    public CustomerJDBCDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return null;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void insertCustomer(Customer customer) {
        String sql = "INSERT INTO customer (name, email, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getAge());
    }

    @Override
    public boolean existsCustomerByEmail(String email) {
        return false;
    }

    @Override
    public void deleteCustomer(Customer customer) {

    }

    @Override
    public void updateCustomer(Customer customer) {
    }
}
