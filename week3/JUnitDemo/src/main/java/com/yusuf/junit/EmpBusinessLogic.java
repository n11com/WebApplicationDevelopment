package com.yusuf.junit;

import com.yusuf.junit.slowww.MySlowDatabaseConnector;

import java.util.Arrays;
import java.util.List;

public class EmpBusinessLogic {

    public MySlowDatabaseConnector connector = new MySlowDatabaseConnector();

    public List<Employee> getEmployeesFromDatabase(){
        List<Employee> employees = connector.getEmployees();

        for (Employee employee : employees) {
            employee.setName("Dummy Name");
        }

        return employees;
    }

    public double calculateYearlySalary(Employee employee) {
        return employee.getSalary() * 12;
    }

    public int totalAgeOfEmployees(Employee ... employees){
        /*
         * if these lines doesn't compile, that means you are not using Java 8.
         * Switch to Java 8 or change the code to a simple loop
         */
        return Arrays.asList(employees)
                .stream()
                .mapToInt(employee -> employee.getAge())
                .sum();
    }


    public void myDummyMethod(boolean throwException){
        if( throwException )
            throw new RuntimeException("Test");

        return;
    }
}