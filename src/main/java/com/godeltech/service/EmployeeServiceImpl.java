package com.godeltech.service;

import com.godeltech.converter.Converter;
import com.godeltech.dao.EmployeeDao;
import com.godeltech.dto.EmployeeDTO;
import com.godeltech.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<EmployeeDTO> findAll() {
        List <Employee> employees = employeeDao.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee: employees) {
            employeeDTOS.add(Converter.convert(employee));
        }
        return employeeDTOS;
    }

    public EmployeeDTO getById(int id) {
        Employee employee = employeeDao.getById(id);
        return employee != null ? Converter.convert(employee) : null;
    }

    public void create(EmployeeDTO employeeDTO) throws ParseException{
        employeeDao.create(Converter.convert(employeeDTO));
    }

    public void update(EmployeeDTO employeeDTO) throws ParseException{
        employeeDao.update(Converter.convert(employeeDTO));
    }

    public void delete(int id) {
        employeeDao.delete(id);
    }
}
