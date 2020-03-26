package com.example.cacheapp.repository;

import com.example.cacheapp.model.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
