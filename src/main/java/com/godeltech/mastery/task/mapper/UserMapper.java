package com.godeltech.mastery.task.mapper;

import com.godeltech.mastery.task.dto.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getLong("employee_id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setDepartment_id(resultSet.getLong("department_id"));
        employee.setJob_title(resultSet.getString("job_title"));
        employee.setGender(resultSet.getString("gender"));
        employee.setDate_of_birth(resultSet.getDate("date_of_birth"));
        return employee;
    }
}
