package com.example.cacheapp.service.impl;

import com.example.cacheapp.model.Customer;
import com.example.cacheapp.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CustomerCacheSchedulerServiceImpl {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void init() {
        update();
        //scheduleUpdateAsync();
    }

    public void update() {
        for (Customer customer : customerRepository.findAll()) {
            cacheManager.getCache("customers").put(customer.getCustomerNumber(), customer);
        }
    }
}
