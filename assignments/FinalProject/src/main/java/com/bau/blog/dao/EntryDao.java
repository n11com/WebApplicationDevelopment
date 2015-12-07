package com.bau.blog.dao;

import com.bau.blog.model.Entry;
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
public class EntryDao {

    private JdbcTemplate jdbcTemplate;

    public void addEntry(Entry entry, User user){
        String sql = "INSERT INTO entries (title, entry, author) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, entry.getTitle(),
                entry.getEntry(),
                user.getId());
    }

    public List<Entry> getEntries(){
        String sql = "select e.id, e.title, e.entry, e.create_date, u.firstname, u.lastname " +
                     "  from entries e, users u " +
                     " where e.author = u.id ";

        return jdbcTemplate.query(sql, new RowMapper<Entry>() {
            @Override
            public Entry mapRow(ResultSet rs, int rowNum) throws SQLException {
                Entry entry = new Entry();
                entry.setId(rs.getInt("id"));
                entry.setTitle(rs.getString("title"));
                entry.setEntry(rs.getString("entry"));
                entry.setCreateDate(rs.getDate("create_date"));

                User author = new User();
                author.setFirstName(rs.getString("firstname"));
                author.setLastName(rs.getString("lastname"));

                entry.setAuthor(author);

                return entry;
            }
        });
    }

    @Autowired
    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
