package com.financeiro.motor_credito.adaptadores.saida;

import com.financeiro.motor_credito.dominio.modelo.Cliente;
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
