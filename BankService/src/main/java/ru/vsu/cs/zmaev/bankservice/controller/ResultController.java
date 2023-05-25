package ru.vsu.cs.zmaev.bankservice.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.zmaev.bankservice.dto.ResultDto;
import ru.vsu.cs.zmaev.bankservice.service.ResultService;

import java.util.List;

@RestController
public class ResultController {
    private final ResultService service;

    public ResultController(ResultService service) {
        this.service = service;
    }

    @GetMapping("/results")
    public List<ResultDto> getAllAccounts() {
        return service.getAll();
    }

    @PostMapping("/result/new")
    public void saveNew(@RequestBody ResultDto account) {
        service.saveNew(account);
    }

//    @DeleteMapping("/account/delete/{id}")
//    public void deleteAccount(@PathVariable Integer id) {
//        service.deleteAccount(id);
//    }
}
