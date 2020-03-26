package com.example.cacheapp.api;

import com.example.cacheapp.model.Employee;
import com.example.cacheapp.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeApi {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public Employee getCustomer(@PathVariable final Integer employeeId) {
        log.info("Value of path variable employeeId: {}",employeeId);
        Employee fetchedEmployee =  employeeService.getEmployee(employeeId);
        log.info("Received response from Service.  Result {}", fetchedEmployee);
        return fetchedEmployee;
    }
}
