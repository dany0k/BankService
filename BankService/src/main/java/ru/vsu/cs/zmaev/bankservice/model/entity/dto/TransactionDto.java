package ru.vsu.cs.zmaev.bankservice.model.entity.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionDto {
    private Long clerkId;
    private Long clientId;
    private LocalDateTime sendingDateTime;
    private LocalDateTime startDateTime;
}
