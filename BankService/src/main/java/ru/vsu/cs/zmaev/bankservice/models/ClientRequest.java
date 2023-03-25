package ru.vsu.cs.zmaev.bankservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "client_request")
public class ClientRequest implements Serializable  {

    @Id
    @GeneratedValue
    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "request")
    private String request;

    @Column(name = "client_id")
    private Long client_id;
}
