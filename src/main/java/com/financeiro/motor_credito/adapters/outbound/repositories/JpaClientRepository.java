package com.financeiro.motor_credito.adapters.outbound.repositories;

import com.financeiro.motor_credito.adapters.outbound.entities.JpaClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Client Repository
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-01
 */
@Repository
public interface JpaClientRepository extends JpaRepository<JpaClientEntity, Long> {

}
