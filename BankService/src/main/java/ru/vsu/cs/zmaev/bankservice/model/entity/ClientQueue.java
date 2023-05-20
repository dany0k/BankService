package ru.vsu.cs.zmaev.bankservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client_queue")
public class ClientQueue {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "client_queue")
    private Set<Client> clientId;

    @Column(name = "starting_datetime")
    private LocalDateTime startingDateTime;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Transaction transactions;
}
