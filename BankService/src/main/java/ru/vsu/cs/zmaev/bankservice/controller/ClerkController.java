package ru.vsu.cs.zmaev.bankservice.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.zmaev.bankservice.dto.ClerkDto;
import ru.vsu.cs.zmaev.bankservice.service.ClerkService;

import java.util.List;

@RestController
public class ClerkController {
    private final ClerkService service;

    public ClerkController(ClerkService service) {
        this.service = service;
    }

    @PostMapping("/clerk/new")
    public void addNewClerk(@RequestBody ClerkDto clerkDto) {
        service.saveNew(clerkDto);
    }

    @GetMapping("/clerk")
    public List<ClerkDto> getAllManagers() {
        return service.getAll();
    }

    @PutMapping("/clerk/update/{id}")
    public void updateManager(@PathVariable Integer id, @RequestBody ClerkDto clerkDto) {
        service.updateClerk(id, clerkDto);
    }

    @DeleteMapping("/clerk/delete/{id}")
    public void deleteManager(@PathVariable Integer id) {
        service.deleteClerk(id);
    }
}
