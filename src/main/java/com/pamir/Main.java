package com.pamir;

import com.pamir.customer.Customer;
import com.pamir.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            var customers = List.of(
                    new Customer(1, "John", "john@gmail.com", 20),
                    new Customer(2, "Jamila", "Jamila@gmail.com", 30));

            customerRepository.saveAll(customers);
        };
    }
}
