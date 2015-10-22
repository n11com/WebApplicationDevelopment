package com.yusuf.spring.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class InitializeDatabase {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @PostConstruct
    public void initialize(){
        String sql = "CREATE TABLE IF NOT EXISTS employee (" +
                "  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "  name VARCHAR(200) DEFAULT NULL)";

        this.jdbcTemplate.execute(sql);
    }


}
