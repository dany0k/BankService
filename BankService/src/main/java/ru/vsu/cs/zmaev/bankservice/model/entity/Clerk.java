package ru.vsu.cs.zmaev.bankservice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clerk")
public class Clerk {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "clerk_id")
    private Transaction transaction;
}
