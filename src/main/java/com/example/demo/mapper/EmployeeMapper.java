package com.example.demo.mapper;

import com.example.demo.dto.EmployeeCreateDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee employeeCreateDtoToEmployee(EmployeeCreateDto employeeCreateDto);

    EmployeeDto employeeToEmployeeDto(Employee employee);
}
