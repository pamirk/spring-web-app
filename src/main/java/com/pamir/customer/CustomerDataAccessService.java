package com.pamir.customer;

import java.util.List;
import java.util.Optional;

public class CustomerDataAccessService implements CustomerDao {


    private static List<Customer> customers;

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
