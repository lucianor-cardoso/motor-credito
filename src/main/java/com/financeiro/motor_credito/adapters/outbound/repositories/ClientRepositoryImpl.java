package com.financeiro.motor_credito.adapters.outbound.repositories;

import com.financeiro.motor_credito.adapters.outbound.entities.JpaClientEntity;
import com.financeiro.motor_credito.domain.client.Client;
import com.financeiro.motor_credito.domain.client.ClientRepository;
import com.financeiro.motor_credito.utils.mappers.ClientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * ClientRepository Implementation
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-04
 */
@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final JpaClientRepository repository;

    private final ClientMapper mapper;

    public ClientRepositoryImpl(JpaClientRepository repository, ClientMapper mapper) {
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
        Optional<JpaClientEntity> clientEntity = this.repository.findById(id);
        // ajustar para mapper
        return clientEntity.map(mapper::jpaToClient);
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
