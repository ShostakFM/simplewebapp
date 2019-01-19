package com.godeltech.mastery.task.dao;

import com.godeltech.mastery.task.dto.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> viewAll();

    Employee getById(int id);

    void add(Employee employee);

    void remove(int id);

    void update(Employee employee);
}
