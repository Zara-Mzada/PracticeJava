package com.student.mapper;

import com.student.dao.entity.DepartmentEntity;
import com.student.dto.DepartmentCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    @Mapping(target = "departmentName", source = "name")
    DepartmentEntity createDtoToEntity(DepartmentCreateDto departmentCreateDto);

    @Mapping(source = "departmentName", target = "name")
    DepartmentCreateDto entityToCreateDto(DepartmentEntity departmentEntity);
}
