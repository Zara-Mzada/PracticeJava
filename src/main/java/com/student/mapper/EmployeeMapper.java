package com.student.mapper;

import com.student.dao.entity.EmployeeEntity;
import com.student.dto.EmployeeCreateDto;
import com.student.dto.EmployeeResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeEntity createDtoToEntity(EmployeeCreateDto employeeCreateDto);

    EmployeeCreateDto entityToCreateDto(EmployeeEntity employeeEntity);

    EmployeeResponseDto entityToResponseDto(EmployeeEntity employeeEntity);

    List<EmployeeResponseDto> entityToResponseDto(List<EmployeeEntity> employeeEntity);
}
