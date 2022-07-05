package com.example.advertisementservice.controller;

import com.example.advertisementservice.dto.AdvertisementRequest;
import com.example.advertisementservice.service.AdvertisementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/advertisement")
@RequiredArgsConstructor
public class AdvertisementController {
    private final AdvertisementService advertisementService;

    @PostMapping
    public String createAdvertisement(@RequestBody AdvertisementRequest advertisementRequest){
        advertisementService.createAdvertisement(advertisementRequest);
        return "Talebiniz Alindi";
    }
}
