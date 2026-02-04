package com.student.dto;

import com.student.util.enums.BrandEnum;
import com.student.util.enums.OSEnum;
import lombok.Data;

@Data
public class PhoneUpdateDto {
    private String model;
    private BrandEnum brand;
    private Double price;
    private OSEnum osSystem;
}
