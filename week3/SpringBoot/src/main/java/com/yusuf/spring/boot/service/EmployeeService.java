package com.yusuf.spring.boot.service;

import com.yusuf.spring.boot.model.Employee;
import com.yusuf.spring.boot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(final EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee save(final Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getList() {
        return repository.findAll();
    }

}