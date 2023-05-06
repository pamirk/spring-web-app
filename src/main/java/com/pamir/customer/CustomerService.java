package com.pamir.customer;

import com.pamir.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomerById(Integer id) {
        return customerDao.selectCustomerById(id)
                .orElseThrow(() -> new ResourceNotFound("Customer with id [%s] does not exists".formatted(id)));

    }

    // git commit -m "Add customer "
    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        if (customerDao.existsCustomerByEmail(customerRegistrationRequest.email())) {
            throw new IllegalStateException("Email already taken");
        }
        Customer customer = new Customer(
                customerRegistrationRequest.name(),
                customerRegistrationRequest.email(),
                customerRegistrationRequest.age());

        customerDao.insertCustomer(
                customer);
    }
}
