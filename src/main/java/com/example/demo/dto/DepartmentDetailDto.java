package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDetailDto {
    String uuid;
    String name;
    String status;
    List<EmployeeDto> employeeDtoList;
    int amountOfStudent;
}
