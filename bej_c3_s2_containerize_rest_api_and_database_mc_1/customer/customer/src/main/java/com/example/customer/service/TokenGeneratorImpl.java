package com.example.customer.service;

import com.example.customer.domain.Customer;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class TokenGeneratorImpl implements ITokenGenerator{
    @Override
    public Map<String, String> generateToken(Customer customer) {
        Map<String, String> result = new HashMap<>();
        Map<String, Object> customerData = new HashMap<>();
        customerData.put("customerId",customer.getCustomerId());
        customerData.put("customerRole",customer.getRole());
        String myToken = Jwts.builder()
                .setClaims(customerData)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretKeyForWave46")
                .compact();
        result.put("Token",myToken);
        result.put("Message","User Login Successfully!");
        return result;
    }
}
