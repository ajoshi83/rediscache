package com.example.cacheapp.repository;

import com.example.cacheapp.model.Customer;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Optional<Customer> findByCustomerNumber(final Long customerNumber);
}
