package ru.vsu.cs.zmaev.bankservice.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.zmaev.bankservice.model.entity.Clerk;

import java.util.List;

@Repository
public interface ClerkRepository extends JpaRepository<Clerk, Integer> {
    @NonNull List<Clerk> findAll();

    @Query("SELECT c FROM Clerk c WHERE c.id = :id")
    Clerk findClerkById(Integer id);
}
