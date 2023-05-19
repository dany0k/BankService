package ru.vsu.cs.zmaev.bankservice.models;

import jakarta.persistence.*;


@Table(name = "client")
@Entity
public class Client {
    @Id
    private long clientId;
    private String firstname;
    private String secondname;


}
