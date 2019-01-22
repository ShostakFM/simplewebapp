package com.godeltech.service;

import com.godeltech.dao.EmployeeDao;
import com.godeltech.dto.EmployeeDTO;
import com.godeltech.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeDao employeeDao;

    private EmployeeDTO convert (Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmployeeId(employee.getEmployeeId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setDepartmentId(employee.getDepartmentId());
        employeeDTO.setJobTitle(employee.getJobTitle());
        employeeDTO.setGender(employee.getGender().toString());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth().toString());
        return employeeDTO;
    }

    private Employee convert (EmployeeDTO employeeDTO) throws ParseException {
        Employee employee = new Employee();
        employee.setEmployeeId(employeeDTO.getEmployeeId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setDepartmentId(employeeDTO.getDepartmentId());
        employee.setJobTitle(employeeDTO.getJobTitle());
        employee.setGender(employeeDTO.getGender());
        employee.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(employeeDTO.getDateOfBirth()));
        return employee;

    }

    public List<EmployeeDTO> findAll() {
        List <Employee> employees = employeeDao.findAll();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee: employees) {
            employeeDTOS.add(convert(employee));
        }
        return employeeDTOS;
    }

    public EmployeeDTO getById(int id) {
        Employee employee = employeeDao.getById(id);
        return employee != null ? convert(employee) : null;
    }

    public void create(EmployeeDTO employeeDTO) throws ParseException{
        employeeDao.create(convert(employeeDTO));
    }

    public void update(EmployeeDTO employeeDTO) throws ParseException{
        employeeDao.update(convert(employeeDTO));
    }

    public void delete(int id) {
        employeeDao.delete(id);
    }
}
