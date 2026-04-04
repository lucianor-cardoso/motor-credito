package com.financeiro.motor_credito.domain.client;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Client Object
 *
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
public class Client {

    private Long idClient;
    private String name;
    private String cpf;
    private LocalDate birthDate;

    public Client() {
    }

    public Client(Long idClient, String name, String cpf, LocalDate dateBirth) {
        this.idClient = idClient;
        this.name = name;
        this.cpf = cpf;
        this.birthDate = dateBirth;
    }

    public Client(String name, String cpf, LocalDate birthDate) {
        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;
        return Objects.equals(idClient, client.idClient)
                && Objects.equals(name, client.name)
                && Objects.equals(cpf, client.cpf)
                && Objects.equals(birthDate, client.birthDate);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = Objects.hashCode(idClient);
        result = prime * result + Objects.hashCode(name);
        result = prime * result + Objects.hashCode(cpf);
        result = prime * result + Objects.hashCode(birthDate);
        return result;
    }

    @Override
    public String toString() {
        return "Client {" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dateBirth=" + birthDate +
                '}';
    }

}
