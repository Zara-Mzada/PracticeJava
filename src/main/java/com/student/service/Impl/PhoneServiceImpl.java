package com.student.service.Impl;

import com.student.dao.entity.PhoneEntity;
import com.student.dao.repository.PhoneRepository;
import com.student.dto.PhoneCreateDto;
import com.student.dto.PhoneResponseDto;
import com.student.dto.PhoneUpdateDto;
import com.student.mapper.PhoneMapper;
import com.student.service.PhoneService;
import com.student.util.enums.BrandEnum;
import com.student.util.enums.OSEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    public void addPhone(PhoneCreateDto phoneCreateDto){
        phoneRepository.save(phoneMapper.createDtoToEntity(phoneCreateDto));
    }

    public PhoneResponseDto getPhone(Long id){
        return phoneMapper.entityToRequestDto(
                phoneRepository.findById(id).orElse(new PhoneEntity()));
    }

    public List<PhoneResponseDto> getPhones(){
        return phoneMapper.entitiesToRequestDtos(
                phoneRepository.findAll());
    }

    public List<PhoneResponseDto> priceMoreThan1000(){
        return phoneMapper.entitiesToRequestDtos(phoneRepository.findAll()
                .stream()
                .filter(p->p.getPrice()>1000)
                .toList());
    }

    public List<PhoneResponseDto> priceAndBrand(){
        return phoneMapper.entitiesToRequestDtos(
                phoneRepository.findAll()
                        .stream()
                        .filter(p ->
                            p.getPrice()>1000 && p.getBrand().equals(BrandEnum.SAMSUNG)
                        )
                        .toList()
        );
    }

    public List<PhoneUpdateDto> updateOS(Double price){
        List<PhoneEntity> list = phoneRepository.findAll()
                .stream()
                .filter(p->p.getPrice()>price)
                .map(
                        (e) -> {
                            e.setOsSystem(OSEnum.IOS);
                           return e;
                        }
                )
                .toList();
        return phoneMapper.entitiesToUpdateDtos(phoneRepository.saveAll(list));
    }
}
