package com.example.notificationservice.service;

import com.example.notificationservice.dao.NotificationRepository;
import com.example.notificationservice.dto.AdvertisementRequest;
import com.example.notificationservice.entity.Notification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final NotificationRepository notificationRepository;

    @RabbitListener(queues = "${queue.name}")
    public void consume(@Payload AdvertisementRequest advertisementRequest){
        Notification notification = new Notification();
        notification.setCreatedAt(LocalDateTime.now());
        notification.setUserId(advertisementRequest.getUserId());
        notification.setMessage(advertisementRequest.getDescription());
        notification.setState("SENT");
        log.info("Notification gonderildi.");
        notificationRepository.save(notification);
    }
}
