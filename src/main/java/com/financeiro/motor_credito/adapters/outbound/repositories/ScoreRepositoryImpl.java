package com.financeiro.motor_credito.adapters.outbound.repositories;

import com.financeiro.motor_credito.adapters.outbound.entities.JpaScoreEntity;
import com.financeiro.motor_credito.domain.score.Score;
import com.financeiro.motor_credito.domain.score.ScoreRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Score Repository
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-07
 */
@Repository
public class ScoreRepositoryImpl implements ScoreRepository {

    private final JpaScoreRepository repository;

    public ScoreRepositoryImpl(JpaScoreRepository jpaScoreRepository) {
        this.repository = jpaScoreRepository;
    }

    @Override
    public Score save(Score score) {
        JpaScoreEntity jpaScoreEntity = new JpaScoreEntity();
        return this.repository.save(jpaScoreEntity);
    }

    @Override
    public List<Score> findAllByClientId(Long clientId) {
        return this.repository.findAll();
    }
}
