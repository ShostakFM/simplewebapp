package com.godeltech.converter;

import com.godeltech.dto.EmployeeDTO;
import com.godeltech.entity.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Converter {
    public static EmployeeDTO convert (Employee employee) {
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
    public static Employee convert (EmployeeDTO employeeDTO) throws ParseException {
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
}
