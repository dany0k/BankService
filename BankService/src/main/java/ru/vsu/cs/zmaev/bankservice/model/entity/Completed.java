package ru.vsu.cs.zmaev.bankservice.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "completed")
public class Completed {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "completed")
    private Set<Transaction> transactions;

    @Column(name = "sending_datetime")
    private LocalDateTime sending_datetime;

    @Column(name = "start_datetime")
    private LocalDateTime start_datetime;

    @Column(name = "end_datetime")
    private LocalDateTime end_datetime;

    @Column(name = "payment")
    private float payment;
}
