package com.example.cacheapp.service.impl;

import com.example.cacheapp.model.Employee;
import com.example.cacheapp.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class CacheSchedulerServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private CacheManager cacheManager;

    @PostConstruct
    public void init() {
        update();
    }

    public void update() {
        for (Employee employee : employeeRepository.findAll()) {
            cacheManager.getCache("employees").put(employee.getEmployeeNo(), employee);
        }
    }
}
