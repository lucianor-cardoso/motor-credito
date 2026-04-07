package com.financeiro.motor_credito.application.service;

import com.financeiro.motor_credito.application.dto.ClientRequestDto;
import com.financeiro.motor_credito.application.dto.ClientResponseDto;
import com.financeiro.motor_credito.application.usecase.ClientUseCases;
import com.financeiro.motor_credito.domain.client.Client;
import com.financeiro.motor_credito.domain.client.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public ClientResponseDto createClient(ClientRequestDto clientDto) {
        Client newClient = new Client(clientDto.getName(), clientDto.getCpf(), clientDto.getBirthDate());
        newClient = repository.save(newClient);
        return new ClientResponseDto(
                newClient.getClientId(),
                newClient.getName(),
                newClient.getCpf(),
                newClient.getBirthDate());
    }

    @Override
    public ClientResponseDto getClient(Long id) {
        Optional<Client> client = repository.findById(id);
        return new ClientResponseDto(
                client.get().getClientId(),
                client.get().getName(),
                client.get().getCpf(),
                client.get().getBirthDate());
    }

    @Override
    public List<ClientResponseDto> getClients() {
        return repository.findAll()
                .stream()
                .map(client -> new ClientResponseDto(
                        client.getClientId(),
                        client.getName(),
                        client.getCpf(),
                        client.getBirthDate()))
                .toList();
    }

    @Override
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

}
