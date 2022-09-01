package com.example.demo.mapper;

import com.example.demo.dto.DepartmentCreateDto;
import com.example.demo.dto.DepartmentDetailDto;
import com.example.demo.dto.EmployeeCreateDto;
import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department departmentCreateDtoToDepartment(DepartmentCreateDto departmentCreateDto);
    DepartmentDetailDto departmentToDepartmentDetailDto(Department department);
}
