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

    public List<Employee> ViewAll() {
        return employeeDao.ViewAll();
    }
}
