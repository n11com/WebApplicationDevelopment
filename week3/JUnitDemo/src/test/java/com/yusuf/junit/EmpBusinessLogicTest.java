package com.yusuf.junit;

import org.junit.Assert;
import org.junit.Test;

public class EmpBusinessLogicTest {

    EmpBusinessLogic businessLogic =new EmpBusinessLogic();

    @Test
    public void shouldCalculateTotalAge() {
        Employee employee1 = new Employee("Yusuf", 2000, 33);
        Employee employee2 = new Employee("Uğur", 3000, 29);
        Employee employee3 = new Employee("Ahmet", 4000, 31);
        Employee employee4 = new Employee("Mehmet", 5000, 45);

        Assert.assertEquals(businessLogic.totalAgeOfEmployees(employee1, employee2, employee3, employee4), 138);
    }

    @Test
    public void shouldCalculateYearlySalary() {
        Employee employee = new Employee();
        employee.setName("Yusuf");
        employee.setAge(33);
        employee.setSalary(2000);
        double salary= businessLogic.calculateYearlySalary(employee);
        Assert.assertEquals(24000, salary, 0.0);
    }

}