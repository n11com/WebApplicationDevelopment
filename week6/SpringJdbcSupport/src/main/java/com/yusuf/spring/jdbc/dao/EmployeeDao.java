package com.yusuf.spring.jdbc.dao;

import com.yusuf.spring.jdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addEmployee(Employee employee){
        String sql = "INSERT INTO employee(name) VALUES(?)";

        int result = jdbcTemplate.update(sql, employee.getName());

        if( result > 0 ){
            System.out.println("Employee saved successfully");
        }
    }

    public List<Employee> getAllEmployees(){
        String sql = "SELECT id, name FROM employee";

        List<Employee> employeeList = jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));

                return employee;
            }
        });

        return employeeList;
    }
}
