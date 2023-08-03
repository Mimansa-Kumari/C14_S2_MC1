package com.example.customer.service;

import com.example.customer.domain.Customer;
import com.example.customer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Customer registerUser(Customer customer) {
        return iCustomerRepository.save(customer);
    }

    @Override
    public Customer checkLogin(Customer customer) {
        return iCustomerRepository.findByCustomerIdAndCustomerPassword(customer.getCustomerId(),customer.getCustomerPassword());
    }
}
