package com.financeiro.motor_credito.adapters.outbound.repositories;

import com.financeiro.motor_credito.adapters.outbound.entities.JpaClientEntity;
import com.financeiro.motor_credito.domain.client.Client;
import com.financeiro.motor_credito.domain.client.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * ClientRepository Implementation
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-04
 */
@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private final JpaClientRepository repository;

    public ClientRepositoryImpl(JpaClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client save(Client client) {
        JpaClientEntity clientEntity = new JpaClientEntity(client);
        this.repository.save(clientEntity);
        return new Client(clientEntity.getClientId(),
                clientEntity.getName(),
                clientEntity.getCpf(),
                clientEntity.getBirthDate());
    }
/*

    @Override
    public Optional<Client> findById(Long id) {
        Optional<JpaClientEntity> clientEntity = this.repository.findById(id);
        // ajustar para mapper
        return clientEntity
                .map(entity -> new Client(
                        entity.getClientId(),
                        entity.getName(),
                        entity.getCpf(), entity.
                        getBirthDate()));
    }
    @Override
    public List<Client> findAll() {
        return this.repository.findAll()
                .stream()
                .map(entity -> new Client(
                        entity.getClientId(),
                        entity.getName(),
                        entity.getCpf(), entity.
                        getBirthDate()))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }
*/
}
