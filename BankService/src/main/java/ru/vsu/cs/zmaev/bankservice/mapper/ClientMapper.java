package ru.vsu.cs.zmaev.bankservice.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.zmaev.bankservice.dto.ClientDto;
import ru.vsu.cs.zmaev.bankservice.model.entity.Client;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDto toDto(Client client);
    Client toEntity(ClientDto dto);
}
