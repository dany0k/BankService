package ru.vsu.cs.zmaev.bankservice.service;//package ru.vsu.cs.javaweb.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.zmaev.bankservice.dto.ResultDto;
import ru.vsu.cs.zmaev.bankservice.mapper.ResultMapper;
import ru.vsu.cs.zmaev.bankservice.model.entity.BankTransaction;
import ru.vsu.cs.zmaev.bankservice.model.entity.Result;
import ru.vsu.cs.zmaev.bankservice.repository.ResultRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultService {
    private final ResultRepository repository;
    private final ResultMapper mapper;

    public ResultService(ResultRepository repository, ResultMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void saveNew(ResultDto resultDto) {
        Result newResult = mapper.toEntity(resultDto);
        BankTransaction bankTransaction = repository.findTransactionById(resultDto.getTransactionId());
        newResult.setBankTransaction(bankTransaction);
        repository.save(newResult);
    }

    public List<ResultDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }
    public void deleteResult(Integer id) {
        repository.delete(repository.findResultById(id));
    }
}
