package ru.vsu.cs.zmaev.bankservice.service;//package ru.vsu.cs.javaweb.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.zmaev.bankservice.dto.BankTransactionDto;
import ru.vsu.cs.zmaev.bankservice.mapper.BankTransactionMapper;
import ru.vsu.cs.zmaev.bankservice.model.entity.BankTransaction;
import ru.vsu.cs.zmaev.bankservice.model.entity.Clerk;
import ru.vsu.cs.zmaev.bankservice.model.entity.Client;
import ru.vsu.cs.zmaev.bankservice.repository.BankTransactionRepository;
import ru.vsu.cs.zmaev.bankservice.repository.ClerkRepository;
import ru.vsu.cs.zmaev.bankservice.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BankTransactionService {
    private final BankTransactionMapper mapper;
    private final BankTransactionRepository repository;

    private final ClientRepository clientRepository;
    private final ClerkRepository clerkRepository;

    public BankTransactionService(BankTransactionMapper mapper, BankTransactionRepository repository, ClientRepository clientRepository, ClerkRepository clerkRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.clientRepository = clientRepository;
        this.clerkRepository = clerkRepository;
    }

    public void saveNew(BankTransactionDto bankTransactionDto) {
        repository.save(mapper.toEntity(bankTransactionDto));
    }

    public BankTransaction createTransaction(BankTransactionDto dto) {
        Client client = clientRepository.findByPassport(dto.getClient().getPassport()).orElseThrow();
        Clerk clerk = clerkRepository.findByPassport(dto.getClerk().getPassport()).orElseThrow();
        BankTransaction bankTransaction = mapper.toEntity(dto);
        bankTransaction.setClient(client);
        bankTransaction.setClerk(clerk);
        return repository.save(bankTransaction);
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
