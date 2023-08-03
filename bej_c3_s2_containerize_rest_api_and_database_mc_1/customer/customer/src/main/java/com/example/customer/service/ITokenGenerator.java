package com.example.customer.service;

import com.example.customer.domain.Customer;

import java.util.Map;

public interface ITokenGenerator {
    Map<String,String> generateToken(Customer customer);
}
