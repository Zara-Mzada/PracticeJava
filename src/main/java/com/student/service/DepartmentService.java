package com.student.service;


import com.student.dto.DepartmentCreateDto;
import com.student.dto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    void createDepartment(DepartmentCreateDto departmentCreateDto);
    List<DepartmentResponseDto> getEmployees();
}
