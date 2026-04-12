package com.financeiro.motor_credito.adapters.outbound.repositories.impl;

import com.financeiro.motor_credito.adapters.outbound.entities.JpaClientEntity;
import com.financeiro.motor_credito.adapters.outbound.repositories.JpaClientRepository;
import com.financeiro.motor_credito.domain.model.Client;
import com.financeiro.motor_credito.domain.repository.ClientRepository;
import com.financeiro.motor_credito.utils.mappers.ClientMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * ClientRepository Implementation
 * - Adapter
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-04
 */
@Component
public class ClientRepositoryAdapter implements ClientRepository {

    private final JpaClientRepository repository;
    private final ClientMapper mapper;

    public ClientRepositoryAdapter(JpaClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Client save(Client client) {
        JpaClientEntity clientEntity = mapper.clientToJpa(client);
        this.repository.save(clientEntity);
        return mapper.jpaToClient(clientEntity);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return this.repository.findById(id)
                .map(mapper::jpaToClient);
    }

    @Override
    public List<Client> findAll() {
        return this.repository.findAll()
                .stream()
                .map(mapper::jpaToClient)
                .toList();
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

}
