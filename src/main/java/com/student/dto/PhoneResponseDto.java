package com.student.dto;

import com.student.util.enums.BrandEnum;
import com.student.util.enums.OSEnum;
import lombok.Data;

@Data
public class PhoneResponseDto {
    private String model;
    private BrandEnum brand;
    private OSEnum osSystem;
    private Double price;
}
