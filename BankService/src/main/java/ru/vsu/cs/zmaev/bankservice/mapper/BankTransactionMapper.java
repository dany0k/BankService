package ru.vsu.cs.zmaev.bankservice.mapper;

import org.mapstruct.Mapper;
import ru.vsu.cs.zmaev.bankservice.dto.BankTransactionDto;
import ru.vsu.cs.zmaev.bankservice.model.entity.BankTransaction;

@Mapper(componentModel = "spring")
public interface BankTransactionMapper {
    BankTransactionDto toDto(BankTransaction client);
    BankTransaction toEntity(BankTransactionDto dto);
}
