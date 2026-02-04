package com.student.service;

import com.student.dto.PhoneCreateDto;
import com.student.dto.PhoneResponseDto;
import com.student.dto.PhoneUpdateDto;

import java.util.List;

public interface PhoneService {
    void addPhone(PhoneCreateDto phoneCreateDto);
    PhoneResponseDto getPhone(Long id);
    List<PhoneResponseDto> getPhones();
    List<PhoneResponseDto> priceMoreThan1000();
    List<PhoneResponseDto> priceAndBrand();
    List<PhoneUpdateDto> updateOS(Double price);
}
