package com.financeiro.motor_credito.adapters.outbound.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

/**
 * JpaClientEntity
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
@Getter
@Setter
@Entity
@Table(name = "client")
public class JpaClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "client_name", length = 100)
    private String name;

    @Column(name = "cpf", unique = true, length = 11)
    private String cpf;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    public JpaClientEntity() {
        // default constructor.
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        JpaClientEntity that = (JpaClientEntity) o;
        return Objects.equals(clientId, that.clientId)
                && Objects.equals(name, that.name)
                && Objects.equals(cpf, that.cpf)
                && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = Objects.hashCode(clientId);
        result = prime * result + Objects.hashCode(name);
        result = prime * result + Objects.hashCode(cpf);
        result = prime * result + Objects.hashCode(birthDate);
        return result;
    }

    @Override
    public String toString() {
        return "JpaClientEntity {" +
                "idClient=" + clientId +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateBirth=" + birthDate +
                '}';
    }

}
