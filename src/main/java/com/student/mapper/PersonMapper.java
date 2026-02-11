package com.student.mapper;

import com.student.dao.entity.PersonEntity;
import com.student.dto.PersonCreateDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonEntity createDtoToEntity(PersonCreateDto personCreateDto);
}
