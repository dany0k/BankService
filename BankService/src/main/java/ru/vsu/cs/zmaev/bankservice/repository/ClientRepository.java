package ru.vsu.cs.zmaev.bankservice.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.zmaev.bankservice.model.entity.Client;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @NonNull List<Client> findAll();
    @NonNull List<Client> findAllById(@NonNull Iterable<Integer> ids);

    @Query("SELECT c FROM Client c WHERE c.id = :id")
    Client findClientById(Integer id);

    Optional<Client> findByPassport(String passport);
}
