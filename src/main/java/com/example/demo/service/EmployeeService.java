package com.example.demo.service;

import com.example.demo.config.ConstantConfig;
import com.example.demo.dto.EmployeeCreateDto;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeMapper employeeMapper;

    public String addEmployee(EmployeeCreateDto employeeCreateDto) {
        Employee employee = employeeMapper.employeeCreateDtoToEmployee(employeeCreateDto);
        employee.setUuid(UUID.randomUUID().toString());
        employee.setStatus(ConstantConfig.PENDING_EMPLOYEE.getValue());
        Employee result = employeeRepository.save(employee);
        return result.getUuid();
    }

    public String activeEmployee(String employeeUuid) {
        Optional<Employee> employeeOptional = employeeRepository.findById(employeeUuid);
        if (employeeOptional.isEmpty()) ;
        Employee employee = employeeOptional.get();
        employee.setStatus(ConstantConfig.ACTIVE_EMPLOYEE.getValue());
        Employee result = employeeRepository.save(employee);
        return result.getUuid();
    }
}
