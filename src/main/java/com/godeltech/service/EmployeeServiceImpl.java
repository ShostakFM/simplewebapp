package com.godeltech.service;

import com.godeltech.converter.Converter;
import com.godeltech.dao.EmployeeDao;
import com.godeltech.dto.EmployeeDTO;
import com.godeltech.entity.Employee;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    private Converter converter = Mappers.getMapper(Converter.class);

    public List<EmployeeDTO> findAll() {
        List <Employee> employees = employeeDao.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee: employees) {
            employeeDTOS.add(converter.employeeToEmployeeDTO(employee));
        }
        return employeeDTOS;
    }

    public EmployeeDTO getById(int id) {
        Employee employee = employeeDao.getById(id);
        return employee != null ? converter.employeeToEmployeeDTO(employee) : null;
    }

    public void create(EmployeeDTO employeeDTO){
        employeeDao.create(converter.employeeDTOToEmployee(employeeDTO));
    }

    public void update(EmployeeDTO employeeDTO){
        employeeDao.update(converter.employeeDTOToEmployee(employeeDTO));
    }

    public void delete(int id) {
        employeeDao.delete(id);
    }
}
