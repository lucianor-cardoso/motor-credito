package com.financeiro.motor_credito.dominio.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Entidade Cliente
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;

    @Column(name = "nome_cliente", length = 100)
    private String nome;

    @Column(name = "des_cpf", unique = true, length = 11)
    private String cpf;

    @Column(name = "dat_nascimento")
    private LocalDate dataNascimento;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;
        return Objects.equals(idCliente, cliente.idCliente)
                && Objects.equals(nome, cliente.nome)
                && Objects.equals(cpf, cliente.cpf)
                && Objects.equals(dataNascimento, cliente.dataNascimento);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = Objects.hashCode(idCliente);
        result = prime * result + Objects.hashCode(cpf);
        result = prime * result + Objects.hashCode(nome);
        result = prime * result + Objects.hashCode(dataNascimento);
        return result;
    }

    @Override
    public String toString() {
        return "Cliente {" +
                "idCliente=" + idCliente +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
