package ru.vsu.cs.zmaev.bankservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "total_profit")
    private Integer totalProfit;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private BankTransaction bankTransaction;
}
