package com.financeiro.motor_credito.domain.repository;

import com.financeiro.motor_credito.domain.model.Client;

import java.util.List;
import java.util.Optional;

/**
 * Client Repository
 * - Outbound Port
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-04
 */
public interface ClientRepository {
    Client save(Client client);

    Optional<Client> findById(Long id);

    List<Client> findAll();

    void deleteById(Long id);

}
