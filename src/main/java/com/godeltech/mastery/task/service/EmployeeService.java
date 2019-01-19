package com.godeltech.mastery.task.service;

import com.godeltech.mastery.task.dto.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> viewAll();

    Employee getById(int id);

    void add(Employee employee);

    void remove(int id);

    void update(Employee employee);
}
