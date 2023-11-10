package com.pamir.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {
}
