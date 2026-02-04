package com.student.mapper;

import com.student.dto.StudentCreateDTO;
import com.student.dao.entity.StudentEntity;
import org.springframework.stereotype.Component;

@Component
public class AllMapper {

    public StudentEntity simpleDtoToEntity(StudentCreateDTO studentCreateDTO){
        StudentEntity entity = new StudentEntity();
        entity.setFirstName(studentCreateDTO.getFirstName());
        entity.setLastName(studentCreateDTO.getLastName());
        entity.setAge(studentCreateDTO.getAge());
        return entity;
    }
}
