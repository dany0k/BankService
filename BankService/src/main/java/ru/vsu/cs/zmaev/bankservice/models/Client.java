package ru.vsu.cs.zmaev.bankservice.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Table(name = "client")
@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "secondname")
    private String secondname;

}
