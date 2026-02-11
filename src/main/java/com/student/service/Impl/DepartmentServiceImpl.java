package com.student.service.Impl;

import com.student.dao.repository.DepartmentRepository;
import com.student.dao.repository.EmployeeRepository;
import com.student.dto.DepartmentCreateDto;
import com.student.dto.DepartmentResponseDto;
import com.student.mapper.AllMapper;
import com.student.mapper.DepartmentMapper;
import com.student.mapper.EmployeeMapper;
import com.student.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentMapper departmentMapper;
    private final EmployeeMapper employeeMapper;
    private final AllMapper allMapper;

    @Override
    public void createDepartment(DepartmentCreateDto departmentCreateDto) {
        departmentRepository.save(departmentMapper.createDtoToEntity(departmentCreateDto));
    }

    @Override
    public List<DepartmentResponseDto> getEmployees() {

        return allMapper.depEntityListToResponseDtoList(departmentRepository.findAll());
    }
}
