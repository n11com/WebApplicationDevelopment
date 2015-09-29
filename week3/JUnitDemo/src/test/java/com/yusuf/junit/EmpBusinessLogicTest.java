package com.yusuf.junit;

import org.junit.*;

import java.io.IOException;

public class EmpBusinessLogicTest {

    EmpBusinessLogic businessLogic =new EmpBusinessLogic();

    @Before
    public void before(){
        System.out.println("Before called");
    }

    @After
    public void after(){
        System.out.println("After called");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Before class is called");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After class is called");
    }

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

    @Test(expected = ArithmeticException.class)
    public void shouldNotCalculateDailySalaryIfParameterIsInvalid(){
        int result = 1/0;
    }

}