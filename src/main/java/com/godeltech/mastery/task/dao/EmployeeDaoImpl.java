package com.godeltech.mastery.task.dao;

import com.godeltech.mastery.task.dto.Employee;
import com.godeltech.mastery.task.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    public List<Employee> ViewAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new UserMapper());
    }
}
