package com.bau.blog.dao;

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
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "  id INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "  firstname VARCHAR(200) DEFAULT NULL," +
                "  lastname VARCHAR(200) DEFAULT NULL," +
                "  username VARCHAR(200) DEFAULT NULL, " +
                "  email VARCHAR(200) DEFAULT NULL," +
                "  password VARCHAR(200) DEFAULT NULL, " +
                "  register_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP())";

        this.jdbcTemplate.execute(sql);
    }


}