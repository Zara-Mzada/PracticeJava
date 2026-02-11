package com.student.controller;

import com.student.dao.entity.EmployeeEntity;
import com.student.dto.DepartmentResponseDto;
import com.student.dto.EmployeeResponseDto;
import com.student.dto.DepartmentCreateDto;
import com.student.dto.EmployeeCreateDto;
import com.student.service.Impl.DepartmentServiceImpl;
import com.student.service.Impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("department")
public class DepartmentController {
    private final DepartmentServiceImpl departmentService;
    private final EmployeeServiceImpl employeeService;

    @PostMapping("create")
    public void createDepartment(@RequestBody DepartmentCreateDto departmentCreateDto){
        departmentService.createDepartment(departmentCreateDto);
    }

    @GetMapping("employees")
    public List<DepartmentResponseDto> getEmployees(){
        return departmentService.getEmployees();
    }


    @PostMapping("empl/create")
    public void createEmployee(@RequestBody EmployeeCreateDto employeeCreateDto){
        employeeService.createEmployee(employeeCreateDto);
    }
}
