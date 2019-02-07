package com.shostak.controller;


import com.shostak.dto.EmployeeDTO;
import com.shostak.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<EmployeeDTO>> findAll() {
        List<EmployeeDTO> employees = employeeService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @ApiOperation(value = "Gets employee by id", nickname = "EmployeeController.getById")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Employee")})
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> getById(@PathVariable int id) {
        EmployeeDTO employeeDTO = employeeService.getById(id);
        if (employeeDTO == null)
            return new ResponseEntity<>(employeeDTO, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @ApiOperation(value = "Creates employee", nickname = "EmployeeController.create")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Employee is created")})
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody EmployeeDTO employeeDTO) {
        try {
            employeeService.create(employeeDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Deletes employee", nickname = "EmployeeController.delete")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Employee is deleted")})
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            employeeService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Edits employee", nickname = "EmployeeController.update")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "Employee is edited")})
    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@RequestBody EmployeeDTO employeeDTO) {
        try {
            employeeService.update(employeeDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
