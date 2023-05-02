package com.pamir.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerListDataAccessService implements CustomerDao {

    //fake database
    private static final List<Customer> customers;

    static {
        customers = List.of(new Customer(1, "John", "john@gmail.com", 20), new Customer(2, "Jamila", "Jamila@gmail.com", 30));
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }
}