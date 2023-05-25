package ru.vsu.cs.zmaev.bankservice.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.zmaev.bankservice.dto.ResultDto;
import ru.vsu.cs.zmaev.bankservice.model.entity.Result;

@Mapper(componentModel = "spring")
public interface ResultMapper {
    ResultDto toDto(Result client);
    Result toEntity(ResultDto dto);
}
