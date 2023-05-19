package ru.vsu.cs.zmaev.bankservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "client_queue")
public class ClientQueue {

    @Id
    @GeneratedValue
    @Column(name = "client_number")
    private Long clientNumber;

    @Column(name = "client_id")
    private Long client_id;


}
