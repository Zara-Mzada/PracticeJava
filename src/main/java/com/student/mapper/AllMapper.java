package com.student.mapper;

import com.student.dao.entity.DepartmentEntity;
import com.student.dao.entity.EmployeeEntity;
import com.student.dto.DepartmentResponseDto;
import com.student.dto.EmployeeResponseDto;
import com.student.dto.StudentCreateDTO;
import com.student.dao.entity.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AllMapper {

    public StudentEntity simpleDtoToEntity(StudentCreateDTO studentCreateDTO){
        StudentEntity entity = new StudentEntity();
        entity.setFirstName(studentCreateDTO.getFirstName());
        entity.setLastName(studentCreateDTO.getLastName());
        entity.setAge(studentCreateDTO.getAge());
        return entity;
    }

    public DepartmentResponseDto entityToResponseDto(DepartmentEntity departmentEntity){
        return new DepartmentResponseDto(
                departmentEntity.getDepartmentName(),
                empEntityListToResponseDtoList(departmentEntity.getEmployees())
        );
    }

    public List<DepartmentResponseDto> depEntityListToResponseDtoList(
            List<DepartmentEntity> departmentEntities) {

        List<DepartmentResponseDto> list = new ArrayList<>();
        for(DepartmentEntity d : departmentEntities){
            list.add(entityToResponseDto(d));
        }

        return list;
    }

    public EmployeeResponseDto entityToResponseDto(EmployeeEntity employeeEntity){
        return new EmployeeResponseDto(
                employeeEntity.getFirstName(),
                employeeEntity.getLastName(),
                employeeEntity.getAge()
        );
    }

    public List<EmployeeResponseDto> empEntityListToResponseDtoList(
            List<EmployeeEntity> employeeEntities){
        List<EmployeeResponseDto> list = new ArrayList<>();
        for(EmployeeEntity e : employeeEntities){
            list.add(entityToResponseDto(e));
        }

        return list;
    }
}
