package ru.vsu.cs.zmaev.bankservice.service;//package ru.vsu.cs.javaweb.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.zmaev.bankservice.dto.BankTransactionDto;
import ru.vsu.cs.zmaev.bankservice.mapper.BankTransactionMapper;
import ru.vsu.cs.zmaev.bankservice.model.entity.BankTransaction;
import ru.vsu.cs.zmaev.bankservice.model.entity.Clerk;
import ru.vsu.cs.zmaev.bankservice.model.entity.Client;
import ru.vsu.cs.zmaev.bankservice.repository.BankTransactionRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankTransactionService {
    private final BankTransactionMapper mapper;
    private final BankTransactionRepository repository;

    public BankTransactionService(BankTransactionMapper mapper, BankTransactionRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    public void saveNew(BankTransactionDto bankTransactionDto) {
        repository.save(mapper.toEntity(bankTransactionDto));
    }

    private BankTransaction createTransaction(Client clt, Clerk clk) {
        Client client = repository.findClient(clt.getPassport());
        Clerk clerk = repository.findClerk(clk.getPassport());
        BankTransaction bankTransaction = new BankTransaction();
        bankTransaction.setClient(client);
        bankTransaction.setClerk(clerk);
        return bankTransaction;
    }

    public List<BankTransactionDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    private BankTransaction findById(Integer id) {
        Optional<BankTransaction> optionalContract = repository.findAll()
                .stream().filter(val -> val.getId().equals(id))
                .findFirst();
        return optionalContract.orElseGet(optionalContract::orElseThrow);
    }

    public void deleteTransaction(Integer id) {
        repository.delete(repository.findTransactionById(id));
    }
}
