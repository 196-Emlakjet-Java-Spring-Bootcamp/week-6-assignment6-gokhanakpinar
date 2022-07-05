package com.example.advertisementservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Advertisement{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private LocalDateTime createdAt;
    private Long userId;

}
