package ru.vsu.cs.zmaev.bankservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "clerk")
public class Clerk implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "clerk_id")
    private Long clerkId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "secondname")
    private String secondname;

}
