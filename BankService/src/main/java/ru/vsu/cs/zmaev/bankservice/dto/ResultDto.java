package ru.vsu.cs.zmaev.bankservice.dto;

import lombok.Data;

@Data
public class ResultDto {

    private Integer id;
    private Integer totalProfit;

    private Integer transactionId;
}
