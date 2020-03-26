package com.example.cacheapp.service.impl;

import com.example.cacheapp.model.Employee;
import com.example.cacheapp.repository.EmployeeRepository;
import com.example.cacheapp.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(final EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Cacheable(value = "employees")
    public Employee getEmployee(int employeeId) {
        log.info("Employee Id: {}",employeeId);
        Optional<Employee> optionalEmployee = employeeRepository.findById(Long.valueOf(employeeId));
        if(optionalEmployee.isPresent()) {
            log.info("Employee found with id: {}",employeeId);
            return optionalEmployee.get();
        } else {
            log.warn("Employee not found with id: {}",employeeId);
            return null;
        }
    }
}
