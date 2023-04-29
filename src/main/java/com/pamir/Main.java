package com.pamir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public GreetResponse greet() {
        return new GreetResponse("Hello");
    }

    // generated http post request
    @PostMapping("/greet")
    public GreetResponse greet(GreetRequest request) {
        return new GreetResponse("Hello " + request.name);
    }


    record GreetResponse(String greet) {
    }

    record GreetRequest(String name) {
    }
}
