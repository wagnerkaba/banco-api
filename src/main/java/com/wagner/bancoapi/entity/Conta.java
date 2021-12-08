package com.wagner.bancoapi.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@MappedSuperclass
public abstract class Conta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int numero;

    @Column(nullable = false)
    protected int agencia;
    protected double saldo;

    @ManyToOne
    protected Cliente cliente;

}
