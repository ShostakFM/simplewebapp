package com.godeltech.mastery.task.service;

import com.godeltech.mastery.task.dao.EmployeeDao;
import com.godeltech.mastery.task.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeDao employeeDao;

    public List<Employee> viewAll() {
        return employeeDao.viewAll();
    }

    public Employee getById(int id) {
        return employeeDao.getById(id);
    }

    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    public void remove(int id) {
        employeeDao.remove(id);
    }

    public void update(Employee employee) {
        employeeDao.update(employee);
    }
}
