package com.financeiro.motor_credito.application.service;

import com.financeiro.motor_credito.application.dto.ClientDto;
import com.financeiro.motor_credito.application.usecase.ClientUseCases;
import com.financeiro.motor_credito.domain.client.Client;
import com.financeiro.motor_credito.domain.client.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClientService
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-04
 */
@Service
public class ClientServiceImpl implements ClientUseCases {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client createClient(ClientDto clientDto) {
        Client newClient = new Client(clientDto.getName(), clientDto.getCpf(), clientDto.getBirthDate());
        newClient = repository.save(newClient);
        return newClient;
    }

    @Override
    public Client getClient(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Client> getClients() {
        return repository.findAll();
    }

}
