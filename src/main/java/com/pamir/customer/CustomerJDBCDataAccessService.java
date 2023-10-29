package com.pamir.customer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jdbc")
public class CustomerJDBCDataAccessService implements CustomerDao {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;


    public CustomerJDBCDataAccessService(JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapper = customerRowMapper;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        String sql = """
                SELECT id, name, email, age
                FROM customer
                """;
        List<Customer> customers = jdbcTemplate.query(sql, customerRowMapper);
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        String sql = """
                SELECT id, name, email, age
                FROM customer
                WHERE id = ?
                """;
        Optional<Customer> customer = jdbcTemplate.query(sql, customerRowMapper, id)
                .stream()
                .findFirst();
        return customer;
    }

    @Override
    public void insertCustomer(Customer customer) {
        String sql = "INSERT INTO customer (name, email, age) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, customer.getName(), customer.getEmail(), customer.getAge());
    }

    @Override
    public boolean existsCustomerWithEmail(String email) {
        String sql = """
                SELECT count(id)
                FROM customer
                WHERE email = ?
                """;
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count != null && count > 0;
    }

    @Override
    public boolean existsCustomerById(Integer customerId) {
        return false;
    }

    @Override
    public void deleteCustomerById(Integer customerId) {

    }


    @Override
    public void updateCustomer(Customer customer) {
    }

    @Override
    public Optional<Customer> selectUserByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void updateCustomerProfileImageId(String profileImageId, Integer customerId) {

    }
}
