package ru.vsu.cs.zmaev.bankservice.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.zmaev.bankservice.model.entity.BankTransaction;
import ru.vsu.cs.zmaev.bankservice.model.entity.Clerk;
import ru.vsu.cs.zmaev.bankservice.model.entity.Client;

import java.util.List;

@Repository
public interface BankTransactionRepository extends JpaRepository<BankTransaction,Integer> {
    @NonNull List<BankTransaction> findAll();

    @Query("SELECT c FROM Client c WHERE c.lastName = :passport")
    Client findClient(String passport);

    @Query("SELECT m FROM Clerk m WHERE m.passport = :passport")
    Clerk findClerk(String passport);

    @Query("SELECT c FROM BankTransaction c WHERE c.id = :id")
    BankTransaction findTransactionById(Integer id);
}
