package com.yusuf.junit;

import java.util.Arrays;

public class EmpBusinessLogic {

    public double calculateYearlySalary(Employee employee) {
        return employee.getSalary() * 12;
    }

    public int totalAgeOfEmployees(Employee ... employees){
        return Arrays.asList(employees)
                .stream()
                .mapToInt(employee -> employee.getAge())
                .sum();
    }
}