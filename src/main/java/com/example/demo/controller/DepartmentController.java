package com.example.demo.controller;

import com.example.demo.config.ControllerPath;
import com.example.demo.dto.DepartmentCreateDto;
import com.example.demo.dto.DepartmentDetailDto;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ControllerPath.DEPARTMENT)
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping("/add")
    public ApiResponse add(@RequestBody DepartmentCreateDto departmentCreateDto) {
        return departmentService.addDepartment(departmentCreateDto);
    }

    @PostMapping("/active/{uuid}")
    public ApiResponse active(@PathVariable("uuid") String departmentUuid) {
        return departmentService.activeDepartment(departmentUuid);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<ApiResponse> detail(@PathVariable("uuid") String departmentUuid) {
        ApiResponse apiResponse = departmentService.detailDepartment(departmentUuid);
        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);

    }
}
