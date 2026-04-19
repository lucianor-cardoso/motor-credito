package com.financeiro.motor_credito.utils.mappers;

import com.financeiro.motor_credito.adapters.outbound.entities.JpaClientEntity;
import com.financeiro.motor_credito.adapters.outbound.repositories.JpaClientRepository;
import com.financeiro.motor_credito.application.dto.ClientRequestDto;
import com.financeiro.motor_credito.application.dto.ClientResponseDto;
import com.financeiro.motor_credito.domain.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Client Mappers
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-09
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "clientId", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.cpf", target = "cpf")
    @Mapping(source = "dto.birthDate", target = "birthDate")
    Client dtoToClient(ClientRequestDto dto);

    @Mapping(source = "jpa.clientId", target = "clientId")
    @Mapping(source = "jpa.name", target = "name")
    @Mapping(source = "jpa.cpf", target = "cpf")
    @Mapping(source = "jpa.birthDate", target = "birthDate")
    Client jpaToClient(JpaClientEntity jpa);

    @Mapping(source = "jpa.clientId", target = "id")
    @Mapping(source = "jpa.name", target = "name")
    @Mapping(source = "jpa.cpf", target = "cpf")
    @Mapping(source = "jpa.birthDate", target = "birthDate")
    ClientResponseDto jpaToClientResponseDto(JpaClientEntity jpa);

    @Mapping(source = "client.clientId", target = "id")
    @Mapping(source = "client.name", target = "name")
    @Mapping(source = "client.cpf", target = "cpf")
    @Mapping(source = "client.birthDate", target = "birthDate")
    ClientResponseDto clientToClientResponseDto(Client client);

    @Mapping(source = "client.clientId", target = "clientId")
    @Mapping(source = "client.name", target = "name")
    @Mapping(source = "client.cpf", target = "cpf")
    @Mapping(source = "client.birthDate", target = "birthDate")
    JpaClientEntity clientToJpa(Client client);

    @Mapping(target = "clientId", ignore = true)
    @Mapping(source = "dto.name", target = "name")
    @Mapping(source = "dto.cpf", target = "cpf")
    @Mapping(source = "dto.birthDate", target = "birthDate")
    JpaClientEntity dtoToJpa(ClientRequestDto dto);
}
