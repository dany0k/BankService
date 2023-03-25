package ru.vsu.cs.zmaev.bankservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Setter
@Getter
@Table(name = "bank")
public class Bank implements Serializable {

    @Id
    @Column(name = "total_profit")
    private Integer totalProfit;

}
