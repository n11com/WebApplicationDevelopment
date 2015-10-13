package com.yusuf.junit.slowww;

import com.yusuf.junit.Employee;

import java.util.ArrayList;
import java.util.List;

public class MySlowDatabaseConnector {

    public List<Employee> getEmployees(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }

        List<Employee> employees = new ArrayList<>();

        employees.add( new Employee("Yusuf", 2000, 33) );
        employees.add( new Employee("Ahmet", 3000, 43) );
        employees.add( new Employee("Mehmet", 4000, 53) );

        return employees;
    }

}
