package ru.vsu.cs.zmaev.bankservice.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.zmaev.bankservice.dto.ClientDto;
import ru.vsu.cs.zmaev.bankservice.service.ClientService;

import java.util.List;

@RestController
public class ClientController {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/clients")
    public List<ClientDto> getAllClients() {
        return service.getAll();
    }
    @PostMapping("/clients/new")
    public void saveNewClient(@RequestBody ClientDto client) {
        service.saveNew(client);
    }
    @PutMapping("/clients/update/{id}")
    public void updateClient(@PathVariable Integer id, @RequestBody ClientDto clientDto) {
        service.updateClient(id, clientDto);
    }
    @DeleteMapping("/clients/delete/{id}")
    public void deleteClient(@PathVariable Integer id) {
        service.deleteClient(id);
    }
}