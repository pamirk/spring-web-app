package com.pamir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        // Run the Spring Boot application
        var ctx = SpringApplication.run(Main.class, args);
        String[] beans = ctx.getBeanDefinitionNames();
        // Print all the beans Spring Boot created for us
        for (String bean : beans) {
            System.out.println(bean);
        }
    }

}
