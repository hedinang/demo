package com.example.demo.service;

import com.example.demo.config.ConstantConfig;
import com.example.demo.dto.DepartmentCreateDto;
import com.example.demo.dto.DepartmentDetailDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.exceptions.ApiException;
import com.example.demo.exceptions.ObjectDoesNotExistException;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    public ApiResponse addDepartment(DepartmentCreateDto departmentCreateDto) {
        ApiResponse apiResponse = new ApiResponse();
        Department department = departmentMapper.departmentCreateDtoToDepartment(departmentCreateDto);
        department.setUuid(UUID.randomUUID().toString());
        department.setStatus(ConstantConfig.PENDING_DEPARTMENT.getValue());
        Department result = departmentRepository.save(department);
        apiResponse.setData(result.getUuid());
        return apiResponse;
    }

    public ApiResponse activeDepartment(String departmentUuid) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            Optional<Department> departmentOptional = departmentRepository.findById(departmentUuid);
            if (departmentOptional.isEmpty()) {
                throw new ObjectDoesNotExistException("Not exist any department has uuid: " + departmentUuid);
            }
            Department department = departmentOptional.get();
            department.setStatus(ConstantConfig.ACTIVE_DEPARTMENT.getValue());
            Department result = departmentRepository.save(department);
            apiResponse.setData(result.getUuid());
        } catch (ObjectDoesNotExistException e) {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(404);
            apiResponse.setMessage(e.getMessage());
        }
        return apiResponse;
    }

    public ApiResponse detailDepartment(String departmentUuid) {
        ApiResponse apiResponse = new ApiResponse();
        try {
            Optional<Department> departmentOptional = departmentRepository.findById(departmentUuid);
            if (departmentOptional.isEmpty()) {
                throw new ObjectDoesNotExistException("Not exist any department has uuid: " + departmentUuid);
            }
            Department department = departmentOptional.get();
            DepartmentDetailDto departmentDetailDto = departmentMapper.departmentToDepartmentDetailDto(department);
            List<EmployeeDto> employeeDtoList = employeeRepository.
                    findByDepartmentUuid(departmentUuid).stream().map(e -> employeeMapper.employeeToEmployeeDto(e)).collect(Collectors.toList());
            departmentDetailDto.setEmployeeDtoList(employeeDtoList);
            departmentDetailDto.setAmountOfStudent(employeeDtoList.size());
            apiResponse.setData(departmentDetailDto);
        } catch (ObjectDoesNotExistException e) {
            apiResponse.setStatus(HttpStatus.BAD_REQUEST);
            apiResponse.setStatusCode(404);
            apiResponse.setMessage(e.getMessage());
        }
        return apiResponse;
    }
}
