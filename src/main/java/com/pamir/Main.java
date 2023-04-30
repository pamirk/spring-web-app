package com.pamir;

import com.pamir.customer.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {

    private static List<Customer> customers;

    static {
        customers = List.of(
                new Customer(1, "John", "john@gmail.com", 20),
                new Customer(2, "Jamila", "Jamila@gmail.com", 30));
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("api/v1/customers")
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("api/v1/customers/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Customer with id [%s] does not exists".formatted(id)));
    }
}
