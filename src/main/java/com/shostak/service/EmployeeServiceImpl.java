package com.shostak.service;

import com.shostak.converter.Converter;
import com.shostak.dao.EmployeeDao;
import com.shostak.dto.EmployeeDTO;
import com.shostak.entity.Employee;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return converter.EmployeeListToEmployeeDTOList(employees);
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
