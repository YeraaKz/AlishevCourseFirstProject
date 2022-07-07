package com.company.DAO;

import com.company.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BooksDAO {
    JdbcTemplate jdbcTemplate;

    @Autowired
    public BooksDAO(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate; }


}
