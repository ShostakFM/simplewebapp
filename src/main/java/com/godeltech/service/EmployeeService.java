package com.godeltech.service;

import com.godeltech.dto.EmployeeDTO;

import java.text.ParseException;
import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAll();

    EmployeeDTO getById(int id);

    void create(EmployeeDTO employeeDTO) throws ParseException;

    void update(EmployeeDTO employeeDTO) throws ParseException;

    void delete(int id);
}
