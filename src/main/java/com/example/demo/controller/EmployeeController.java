package com.example.demo.controller;

import com.example.demo.config.ControllerPath;
import com.example.demo.dto.EmployeeCreateDto;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ControllerPath.EMPLOYEE)
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public String add(@RequestBody EmployeeCreateDto employeeCreateDto) {
        return employeeService.addEmployee(employeeCreateDto);
    }

    @PutMapping("/active/{uuid}")
    public String active(@PathVariable("uuid") String employeeUuid) {
        return employeeService.activeEmployee(employeeUuid);
    }
}