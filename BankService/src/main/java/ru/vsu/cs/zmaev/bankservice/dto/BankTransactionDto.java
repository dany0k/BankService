package ru.vsu.cs.zmaev.bankservice.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BankTransactionDto {
    private ClientDto client;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double profit;

    private ClerkDto clerk;
}
