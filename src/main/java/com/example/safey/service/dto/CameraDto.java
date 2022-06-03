package com.example.safey.service.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class CameraDto {

    private Long id;
    private String name;
    private Instant registerDate;

}
