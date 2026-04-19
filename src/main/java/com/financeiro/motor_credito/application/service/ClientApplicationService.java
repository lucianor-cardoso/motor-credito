package com.financeiro.motor_credito.application.service;

import com.financeiro.motor_credito.adapters.outbound.entities.JpaClientEntity;
import com.financeiro.motor_credito.adapters.outbound.repositories.JpaClientRepository;
import com.financeiro.motor_credito.application.dto.ClientRequestDto;
import com.financeiro.motor_credito.application.dto.ClientResponseDto;
import com.financeiro.motor_credito.application.usecase.ClientUseCases;
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

    private final JpaClientRepository repository;
    private final ClientMapper mapper;

    public ClientApplicationService(JpaClientRepository repository, ClientMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public ClientResponseDto createClient(ClientRequestDto clientDto) {
        JpaClientEntity newClient = mapper.dtoToJpa(clientDto);
        newClient = this.repository.save(newClient);
        return mapper.jpaToClientResponseDto(newClient);
    }

    @Override
    public ClientResponseDto getClient(Long id) {
        Optional<JpaClientEntity> client = this.repository.findById(id);
        return mapper.jpaToClientResponseDto(client.orElse(null));
    }

    @Override
    public List<ClientResponseDto> getClients() {
        return repository.findAll()
                .stream()
                .map(mapper::jpaToClientResponseDto)
                .toList();
    }

    @Override
    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

}
