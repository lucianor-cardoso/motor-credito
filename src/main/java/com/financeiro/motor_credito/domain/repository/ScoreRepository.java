package com.financeiro.motor_credito.domain.repository;

import com.financeiro.motor_credito.domain.model.Score;

import java.util.List;

/**
 * Score Repository
 * - Outbound Port
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-07
 */
public interface ScoreRepository {

    Score save(Score score);

    List<Score> findAllByClientId(Long clientId);

}
