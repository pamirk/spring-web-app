package com.pamir.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {

    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);
    void insertCustomer(Customer customer);
    boolean existsCustomerByEmail(String email);
    void deleteCustomer(Customer customer);
    void updateCustomer(Customer customer);
}
