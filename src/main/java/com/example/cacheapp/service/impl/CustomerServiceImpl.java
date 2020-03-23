package com.example.cacheapp.service.impl;

import com.example.cacheapp.model.Customer;
import com.example.cacheapp.repository.CustomerRepository;
import com.example.cacheapp.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Cacheable(value = "customers")
    public Customer getCustomer(int customerNumber) {
        log.info("Customer Number: {}",customerNumber);
        //Optional<Customer> optionalCustomer = customerRepository.findById(Long.valueOf(customerNumber));
        Optional<Customer> optionalCustomer = customerRepository.findByCustomerNumber(Long.valueOf(customerNumber));
        if(optionalCustomer.isPresent()) {
            log.info("Customer found with id: {}",customerNumber);
            return optionalCustomer.get();
        } else {
            log.warn("Customer not found with id: {}",customerNumber);
            return null;
        }
    }
}
