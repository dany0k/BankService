package ru.vsu.cs.zmaev.bankservice.repository;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.zmaev.bankservice.model.entity.BankTransaction;
import ru.vsu.cs.zmaev.bankservice.model.entity.Result;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Integer> {
    @NonNull List<Result> findAll();

    @Query("SELECT c FROM BankTransaction c WHERE c.id = :id")
    BankTransaction findTransactionById(Integer id);

    @Query("SELECT a FROM Result a WHERE a.bankTransaction.id = :id")
    Result findResultById(Integer id);

}
