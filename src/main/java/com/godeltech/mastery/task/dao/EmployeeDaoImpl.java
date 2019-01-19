package com.godeltech.mastery.task.dao;

import com.godeltech.mastery.task.dto.Employee;
import com.godeltech.mastery.task.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    public final JdbcTemplate jdbcTemplate;
    @Autowired
    public EmployeeDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> viewAll() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new EmployeeMapper());
    }

    public Employee getById(int id) {
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        return jdbcTemplate.queryForObject(sql, new EmployeeMapper(), id);
    }

    public void add(Employee employee) {
        String sql = "INSERT INTO employee (first_name, last_name, department_id, job_title, gender, date_of_birth) " +
                "VALUES (?, ? ,? , ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getFirst_name(), employee.getLast_name(), employee.getDepartment_id(),
                employee.getJob_title(), employee.getGender(), employee.getDate_of_birth());
    }

    public void remove(int id) {
        String sql = "DELETE FROM employee WHERE employee_id=?";
        jdbcTemplate.update(sql, id);
    }

    public void update(Employee employee) {
        String sql = "UPDATE employee " +
                "SET first_name=?, last_name=?, department_id=?, job_title=?, gender=?, date_of_birth=? " +
                "WHERE employee_id = ?";
        jdbcTemplate.update(sql, employee.getFirst_name(), employee.getLast_name(), employee.getDepartment_id(),
                employee.getJob_title(), employee.getGender(), employee.getDate_of_birth(), employee.getEmployee_id());
    }
}
