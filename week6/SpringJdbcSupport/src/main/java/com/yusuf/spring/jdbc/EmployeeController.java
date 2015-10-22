package com.yusuf.spring.jdbc;

import com.yusuf.spring.jdbc.dao.EmployeeDao;
import com.yusuf.spring.jdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/list")
    public ModelAndView getEmployees(){
        ModelAndView mav = new ModelAndView("employees");
        mav.addObject("employees", employeeDao.getAllEmployees());

        return mav;
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public RedirectView addEmployee(@RequestParam("name") String name){
        Employee employee = new Employee();
        employee.setName(name);

        employeeDao.addEmployee(employee);

        return new RedirectView("list", true);
    }
}
