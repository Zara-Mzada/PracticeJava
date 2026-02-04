package com.student.controller;

import com.student.dto.PhoneCreateDto;
import com.student.dto.PhoneResponseDto;
import com.student.dto.PhoneUpdateDto;
import com.student.service.Impl.PhoneServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("phone")
public class PhoneController {
    private final PhoneServiceImpl phoneService;

    @PostMapping("add")
    public void addPhone(@RequestBody PhoneCreateDto phoneCreateDto){
        phoneService.addPhone(phoneCreateDto);
    }

    @GetMapping("{id}")
    public PhoneResponseDto getPhone(@PathVariable Long id){
        return phoneService.getPhone(id);
    }

    @GetMapping("all")
    public List<PhoneResponseDto> getPhones(){
        return phoneService.getPhones();
    }

    @GetMapping("priceMore1000")
    public List<PhoneResponseDto> priceMoreThan1000(){
        return phoneService.priceMoreThan1000();
    }

    @GetMapping("price&brand")
    public List<PhoneResponseDto> priceAndBrand(){
        return phoneService.priceAndBrand();
    }

    @PatchMapping("update-os/{price}")
    public List<PhoneUpdateDto> updateOS(@PathVariable Double price){
        return phoneService.updateOS(price);
    }
}
