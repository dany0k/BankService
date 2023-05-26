package ru.vsu.cs.zmaev.bankservice.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.zmaev.bankservice.dto.BankTransactionDto;
import ru.vsu.cs.zmaev.bankservice.service.BankTransactionService;

import java.util.List;

@RestController
public class BankTransactionController {
    private final BankTransactionService service;

    public BankTransactionController(BankTransactionService service) {
        this.service = service;
    }

    @PostMapping("/transactions/new/pass")
    public void addNewOperationByPass(@RequestBody BankTransactionDto transactionDto) {
        service.saveNew(transactionDto);
    }

    @PostMapping("/transaction/new")
    public void addNewOperation(@RequestBody BankTransactionDto transactionDto) {
        service.createTransaction(transactionDto);
    }
    @GetMapping("/transactions")
    public List<BankTransactionDto> getAllContracts() {
        return service.getAll();
    }

    @DeleteMapping("/transaction/delete/{id}")
    public void deleteTransaction(@PathVariable Integer id) {
        service.deleteTransaction(id);
    }
}