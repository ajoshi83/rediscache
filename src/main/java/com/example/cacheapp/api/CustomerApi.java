package com.example.cacheapp.api;

import com.example.cacheapp.model.Customer;
import com.example.cacheapp.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerApi {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public Customer getCustomer(@PathVariable final Integer customerId) {
        log.info("Value of path variable customerId: {}",customerId);
        Customer fetchedCustomer =  customerService.getCustomer(customerId);
        log.info("Received response from Service.  Result {}",fetchedCustomer);
        return fetchedCustomer;
    }
}
