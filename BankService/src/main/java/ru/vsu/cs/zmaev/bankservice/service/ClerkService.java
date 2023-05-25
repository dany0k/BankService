package ru.vsu.cs.zmaev.bankservice.service;

import org.springframework.stereotype.Service;
import ru.vsu.cs.zmaev.bankservice.dto.ClerkDto;
import ru.vsu.cs.zmaev.bankservice.mapper.ClerkMapper;
import ru.vsu.cs.zmaev.bankservice.model.entity.Clerk;
import ru.vsu.cs.zmaev.bankservice.repository.ClerkRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClerkService {
    private final ClerkRepository repository;
    private final ClerkMapper mapper;

    public ClerkService(ClerkRepository repository, ClerkMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public void saveNew(ClerkDto client) {
        repository.save(mapper.toEntity(client));
    }

    public List<ClerkDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public void deleteClerk(Integer id) {
        repository.delete(repository.findClerkById(id));
    }

    public void updateClerk(Integer id, ClerkDto client) {
        Clerk oldClerk = repository.findClerkById(id);
        Clerk clerkNew = mapper.toEntity(client);
        clerkNew.setId(oldClerk.getId());
        repository.save(clerkNew);
    }
}
