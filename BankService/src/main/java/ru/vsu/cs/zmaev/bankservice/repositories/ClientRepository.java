package ru.vsu.cs.zmaev.bankservice.repositories;


import org.springframework.data.repository.CrudRepository;
import ru.vsu.cs.zmaev.bankservice.models.Client;

import java.util.List;

public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findClientBySecondname(String secondname);

    Client findClientBy(long id);
}
