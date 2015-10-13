package com.yusuf.junit;

import com.yusuf.junit.slowww.MySlowDatabaseConnector;
import org.junit.*;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class EmpBusinessLogicTest {

    EmpBusinessLogic businessLogic;

    @Before
    public void before(){
        businessLogic = new EmpBusinessLogic();

        List<Employee> employees = new ArrayList<>();
        employees.add( new Employee("Yusuf", 2000, 33) );

        MySlowDatabaseConnector mockConnector = Mockito.mock(MySlowDatabaseConnector.class);
        Mockito.when( mockConnector.getEmployees() ).thenReturn( employees );

//        Mockito.when( mockConnector.getEmployees() ).thenThrow(new RuntimeException("Hey!"));

        businessLogic.connector = mockConnector;
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

        Assert.assertEquals(24000, salary, 0.0000001);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionOnMyDummyMethod(){
        businessLogic.myDummyMethod(true);
    }

    @Test
    public void shouldNotThrowExceptionOnMyDummyMethod(){
        businessLogic.myDummyMethod(false);
    }


    @Test(expected = ArithmeticException.class)
    public void shouldNotCalculateDailySalaryIfParameterIsInvalid(){
        int result = 1/0;
    }

    @Test
    public void shouldWaitForEmployeesToBeFetched(){
        List<Employee> employees = businessLogic.getEmployeesFromDatabase();

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("Method call is completed");
    }


}