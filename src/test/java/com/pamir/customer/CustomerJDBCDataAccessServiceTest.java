package com.pamir.customer;

import com.pamir.AbstractTestcontainers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerJDBCDataAccessServiceTest extends AbstractTestcontainers {

    private CustomerJDBCDataAccessService underTest;
    private final CustomerRowMapper customerRowMapper = new CustomerRowMapper();

    CustomerJDBCDataAccessServiceTest() {
    }

    @BeforeEach
    void setUp() {
        underTest = new CustomerJDBCDataAccessService(
                new JdbcTemplate(),
                customerRowMapper
        );
    }

    @Test
    void selectAllCustomers() {
    }

    @Test
    void selectCustomerById() {
    }

    @Test
    void insertCustomer() {
    }

    @Test
    void existsCustomerWithEmail() {
    }

    @Test
    void existsCustomerById() {
    }

    @Test
    void deleteCustomerById() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void selectUserByEmail() {
    }

    @Test
    void updateCustomerProfileImageId() {
    }
}