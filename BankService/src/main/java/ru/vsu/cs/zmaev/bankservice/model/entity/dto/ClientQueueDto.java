package ru.vsu.cs.zmaev.bankservice.model.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ClientQueueDto {
    private Long clientId;
    private LocalDateTime sending_datetime;
}
