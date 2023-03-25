package ru.vsu.cs.zmaev.bankservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@Table(name = "bank_transaction")
public class BankTransaction implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "transaction_date")
    private LocalDate transactionDate;

    @Column(name = "profit")
    private Integer profit;

    @Column(name = "client_number")
    private Long clientNumber;

    @Column(name = "clerk_id")
    private Long clerkId;

    @Column(name = "request_id")
    private Long requestId;
}
