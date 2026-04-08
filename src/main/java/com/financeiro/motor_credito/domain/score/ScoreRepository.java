package com.financeiro.motor_credito.domain.score;

import java.util.List;

/**
 * Score Repository
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-07
 */
public interface ScoreRepository {
    Score save(Score score);

    List<Score> findAllByClientId(Long clientId);
}
