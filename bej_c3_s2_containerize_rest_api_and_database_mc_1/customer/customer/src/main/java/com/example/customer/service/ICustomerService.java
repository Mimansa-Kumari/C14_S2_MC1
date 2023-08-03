package com.example.customer.service;

import com.example.customer.domain.Customer;

public interface ICustomerService {
    Customer registerUser(Customer customer);
    Customer checkLogin(Customer customer);
}
