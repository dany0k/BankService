package ru.vsu.cs.zmaev.bankservice.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.zmaev.bankservice.dto.ClerkDto;
import ru.vsu.cs.zmaev.bankservice.model.entity.Clerk;

@Mapper(componentModel = "spring")
public interface ClerkMapper {
    ClerkDto toDto(Clerk client);
    Clerk toEntity(ClerkDto dto);
}
