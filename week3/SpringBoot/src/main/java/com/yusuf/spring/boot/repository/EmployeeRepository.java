package com.yusuf.spring.boot.repository;

import com.yusuf.spring.boot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}