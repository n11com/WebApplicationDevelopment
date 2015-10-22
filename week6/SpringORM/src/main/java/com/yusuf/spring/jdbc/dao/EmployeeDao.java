package com.yusuf.spring.jdbc.dao;

import com.yusuf.spring.jdbc.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addEmployee(Employee employee){
        Serializable returnVal = getCurrentSession().save(employee);

        System.out.println(returnVal);
    }

    @Transactional
    public List<Employee> getAllEmployees(){
        Criteria criteria = getCurrentSession().createCriteria(Employee.class);
        return criteria.list();
    }

    @Transactional
    public List<Employee> getEmployeesOlderThan(int age){
        Criteria criteria = getCurrentSession().createCriteria(Employee.class);
        criteria.add(Restrictions.gt("age", age));
        criteria.addOrder(Order.desc("age"));
        return criteria.list();
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
