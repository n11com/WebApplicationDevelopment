package com.yusuf.spring.boot.controller;

import com.yusuf.spring.boot.model.Employee;
import com.yusuf.spring.boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(final EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> listEmployees() {
        List<Employee> employees = employeeService.getList();
        return employees;
    }

    @RequestMapping(value="/add",method = RequestMethod.POST)
    public String addEmployee(@RequestParam(value = "employeeName", required = false) String employeeName,
                              @RequestParam(value = "employeeId", required = false) String employeeId,
                              @RequestParam(value = "employeeCity", required = false) String employeeCity){
    	Employee employee = new Employee(employeeId,employeeName,employeeCity);
    	employeeService.save(employee);

        return "redirect:index.jsp";
    }
}