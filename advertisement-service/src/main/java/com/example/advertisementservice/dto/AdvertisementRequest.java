package com.example.advertisementservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertisementRequest {
    private String title;
    private BigDecimal price;
    private String description;
    private Long userId;
}
