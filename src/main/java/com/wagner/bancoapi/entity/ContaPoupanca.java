package com.wagner.bancoapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@AllArgsConstructor
public class ContaPoupanca extends Conta{
}
