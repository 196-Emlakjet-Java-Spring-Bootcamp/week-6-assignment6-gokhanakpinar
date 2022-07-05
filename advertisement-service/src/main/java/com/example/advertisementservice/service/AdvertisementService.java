package com.example.advertisementservice.service;

import com.example.advertisementservice.dao.AdvertisementRepository;
import com.example.advertisementservice.dto.AdvertisementRequest;
import com.example.advertisementservice.entity.Advertisement;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AdvertisementService{
    private final AdvertisementRepository advertisementRepository;
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public void createAdvertisement(AdvertisementRequest advertisementRequest){
        Advertisement advertisement = new Advertisement();
        advertisement.setDescription(advertisementRequest.getDescription());
        advertisement.setTitle(advertisementRequest.getTitle());
        advertisement.setPrice(advertisementRequest.getPrice());
        advertisement.setCreatedAt(LocalDateTime.now());
        advertisement.setUserId(advertisementRequest.getUserId());
        advertisementRepository.save(advertisement);
        rabbitTemplate.convertAndSend(queue.getName(), advertisementRequest);
    }
}
