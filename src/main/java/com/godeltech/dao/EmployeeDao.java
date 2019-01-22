package com.godeltech.dao;

import com.godeltech.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee getById(int id);

    void create(Employee employee);

    void update(Employee employee);

    void delete(int id);

}
