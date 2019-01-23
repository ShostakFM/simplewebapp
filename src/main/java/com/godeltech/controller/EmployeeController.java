package com.godeltech.controller;


import com.godeltech.dto.EmployeeDTO;
import com.godeltech.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Api
@RestController
@RequestMapping("employees")
public class EmployeeController {

    public final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @ApiOperation(value = "Gets all employees", nickname = "EmployeeController.findAll")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Employees")})
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EmployeeDTO> findAll() {
        return employeeService.findAll();
    }

    @ApiOperation(value = "Gets employee by id", nickname = "EmployeeController.getById")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Employee")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EmployeeDTO getById(@PathVariable int id) {
        return  employeeService.getById(id);
    }

    @ApiOperation(value = "Creates employee", nickname = "EmployeeController.create")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Employee is created")})
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void create (@RequestBody EmployeeDTO employeeDTO) throws ParseException {
        employeeService.create(employeeDTO);
    }

    @ApiOperation(value = "Deletes employee", nickname = "EmployeeController.delete")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Employee is deleted")})
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete (@PathVariable int id) {
        employeeService.delete(id);
    }

    @ApiOperation(value = "Edits employee", nickname = "EmployeeController.update")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Employee is edited")})
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody EmployeeDTO employeeDTO) throws ParseException{
        employeeService.update(employeeDTO);
    }
}
