package com.financeiro.motor_credito.adapters.outbound.repositories;

import com.financeiro.motor_credito.adapters.outbound.entities.JpaScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA Score Repository
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-07
 */
@Repository
public interface JpaScoreRepository extends JpaRepository<JpaScoreEntity, Long> {
}
