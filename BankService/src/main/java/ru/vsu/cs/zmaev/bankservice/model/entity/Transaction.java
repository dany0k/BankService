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
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "transaction")
    private Set<Clerk> clerk;

    @OneToMany(mappedBy = "transaction")
    private Set<Client> client;

    @Column(name = "sending_datetime")
    private LocalDateTime sendingDateTime;

    @Column(name = "start_datetime")
    private LocalDateTime startDateTime;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clientId;
}
