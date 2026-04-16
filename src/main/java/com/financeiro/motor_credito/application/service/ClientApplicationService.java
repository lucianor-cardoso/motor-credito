package com.financeiro.motor_credito.application.service;

import com.financeiro.motor_credito.application.dto.ClientRequestDto;
import com.financeiro.motor_credito.application.dto.ClientResponseDto;
import com.financeiro.motor_credito.application.usecase.ClientUseCases;
import com.financeiro.motor_credito.domain.model.Client;
import com.financeiro.motor_credito.domain.repository.ClientRepository;
import com.financeiro.motor_credito.utils.mappers.ClientMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Client Application Service
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-04
 */
@Service
public class ClientApplicationService implements ClientUseCases {

    private final ClientRepository repository;
    private final ClientMapper mapper;

    public ClientApplicationService(ClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ClientResponseDto createClient(ClientRequestDto clientDto) {
        Client newClient = mapper.dtoToClient(clientDto);
        newClient = this.repository.save(newClient);
        return mapper.clientToClientResponseDto(newClient);
    }

    @Override
    public ClientResponseDto getClient(Long id) {
        Optional<Client> client = this.repository.findById(id);
        return mapper.clientToClientResponseDto(client.get());
    }

    @Override
    public List<ClientResponseDto> getClients() {
        return repository.findAll()
                .stream()
                .map(mapper::clientToClientResponseDto)
                .toList();
    }

    @Override
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

}
