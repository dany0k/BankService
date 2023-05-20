package ru.vsu.cs.zmaev.bankservice.model.entity.dto;

import lombok.Data;

@Data
public class ClientDto {
    private Long id;
    private String firstname;
    private String lastname;
}
