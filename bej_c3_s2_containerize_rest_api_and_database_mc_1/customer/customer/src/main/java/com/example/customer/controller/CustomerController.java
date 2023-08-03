package com.example.customer.controller;

import com.example.customer.domain.Customer;
import com.example.customer.service.CustomerServiceImpl;
import com.example.customer.service.ICustomerService;
import com.example.customer.service.TokenGeneratorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    TokenGeneratorImpl tokenGenerator;

    //http://localhost:5555/api/v1/register
    @PostMapping("/register")
    public ResponseEntity<?>registerUser(@RequestBody Customer customer)
    {
        if(customer.getRole()==null)
        {
            customer.setRole("role-user");
        }
        return new ResponseEntity<>(customerService.registerUser(customer), HttpStatus.CREATED);
    }

    //http://localhost:5555/api/v1/login
    @GetMapping("/login")
    public ResponseEntity<?>checkLogin(@RequestBody Customer customer)
    {
        Customer validation = customerService.checkLogin(customer);
        if (validation != null)
        {
            return new ResponseEntity<>(tokenGenerator.generateToken(customer),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Authentication Failed!", HttpStatus.EXPECTATION_FAILED);
        }
    }
}
