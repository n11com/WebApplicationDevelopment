package com.bau.blog.dao;

import com.bau.blog.EncryptionUtils;
import com.bau.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    public void addUser(User user){
        String sql = "INSERT INTO users (firstname, lastname, username, email, password) VALUES (?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, user.getFirstName(),
                user.getLastName(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword());
    }

    public User getUser(String username){
        String sql = "SELECT id, firstname, lastname, username, email, password FROM users WHERE username = ?";

        List<User> userList = jdbcTemplate.<User>query(sql, new BeanPropertyRowMapper(User.class), username);

        if( userList.size() > 0 ){
            return userList.get(0);
        }

        return null;
    }

    @Autowired
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
