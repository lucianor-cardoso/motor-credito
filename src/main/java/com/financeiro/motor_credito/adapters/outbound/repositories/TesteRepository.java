package com.financeiro.motor_credito.adapters.outbound.repositories;

import com.financeiro.motor_credito.domain.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TesteRepository extends JpaRepository<Client, Long> {

    @Query(value = "select * from client", nativeQuery = true)
    Client findByClientIdAndCpfNotNull();
}
