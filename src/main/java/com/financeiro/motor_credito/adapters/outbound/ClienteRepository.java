package com.financeiro.motor_credito.adapters.outbound;

import com.financeiro.motor_credito.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório de Clientes
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-01
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
