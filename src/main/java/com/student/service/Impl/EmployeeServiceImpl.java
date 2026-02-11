package com.student.service.Impl;

import com.student.dao.repository.DepartmentRepository;
import com.student.dao.repository.EmployeeRepository;
import com.student.dto.EmployeeCreateDto;
import com.student.mapper.EmployeeMapper;
import com.student.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;

    public void createEmployee(EmployeeCreateDto employeeCreateDto){
        var employee = employeeMapper.createDtoToEntity(employeeCreateDto);

        var department = departmentRepository.findById(
                employeeCreateDto.getDepartmentId()
        ).orElseThrow(()-> new RuntimeException("Not found"));

        employee.setDepartment(department);

        employeeRepository.save(employee);
    }
}
