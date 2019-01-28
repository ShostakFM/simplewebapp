package com.godeltech.service;

import com.godeltech.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDTO> findAll();

    EmployeeDTO getById(int id);

    void create(EmployeeDTO employeeDTO);

    void update(EmployeeDTO employeeDTO);

    void delete(int id);
}
