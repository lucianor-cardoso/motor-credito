package com.financeiro.motor_credito.domain.client;

import java.util.List;
import java.util.Optional;

/**
 * Client Repository
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
