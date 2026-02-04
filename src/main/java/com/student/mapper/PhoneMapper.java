package com.student.mapper;

import com.student.dao.entity.PhoneEntity;
import com.student.dto.PhoneCreateDto;
import com.student.dto.PhoneResponseDto;
import com.student.dto.PhoneUpdateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PhoneMapper {
    PhoneEntity createDtoToEntity(PhoneCreateDto phoneCreateDto);
    PhoneResponseDto entityToRequestDto(PhoneEntity phoneEntity);
    PhoneUpdateDto entityToUpdateDto(PhoneEntity phoneEntity);

    List<PhoneResponseDto> entitiesToRequestDtos(List<PhoneEntity> phoneEntityList);
    List<PhoneUpdateDto> entitiesToUpdateDtos(List<PhoneEntity> phoneEntityList);

}
