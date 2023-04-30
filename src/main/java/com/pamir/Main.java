package com.pamir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class Main {

    private static List<Customer> customers;

    static {
        customers = List.of(new Customer("John", "john@gmail.com", 20), new Customer("Jamila", "Jamila@gmail.com", 30));
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RequestMapping(value = "api/v1/customers", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customers;
    }

    public static class Customer {
        String name;
        String email;
        Integer age;

        public Customer() {
        }

        public Customer(String name, String email, Integer age) {
            this.name = name;
            this.email = email;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return Objects.equals(name, customer.name) && Objects.equals(email, customer.email) && Objects.equals(age, customer.age);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, email, age);
        }

        @Override
        public String toString() {
            return "Customer{" + "name='" + name + '\'' + ", email='" + email + '\'' + ", age=" + age + '}';
        }
    }

}
