package com.godeltech.converter;

import com.godeltech.dto.EmployeeDTO;
import com.godeltech.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface Converter {

    @Mappings({
            @Mapping(target = "employeeId", source = "entity.employeeId"),
            @Mapping(target = "firstName", source = "entity.firstName"),
            @Mapping(target = "lastName", source = "entity.lastName"),
            @Mapping(target = "departmentId", source = "entity.departmentId"),
            @Mapping(target = "jobTitle", source = "entity.jobTitle"),
            @Mapping(target = "gender", source = "entity.gender"),
            @Mapping(target = "dateOfBirth", source = "entity.dateOfBirth", dateFormat = "dd-MM-yyyy")
    })
    EmployeeDTO employeeToEmployeeDTO(Employee entity);

    @Mappings({
            @Mapping(target = "employeeId", source = "dto.employeeId"),
            @Mapping(target = "firstName", source = "dto.firstName"),
            @Mapping(target = "lastName", source = "dto.lastName"),
            @Mapping(target = "departmentId", source = "dto.departmentId"),
            @Mapping(target = "jobTitle", source = "dto.jobTitle"),
            @Mapping(target = "gender", source = "dto.gender"),
            @Mapping(target = "dateOfBirth", source = "dto.dateOfBirth", dateFormat = "dd-MM-yyyy")
    })
    Employee employeeDTOToEmployee(EmployeeDTO dto);

}
