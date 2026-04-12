package com.financeiro.motor_credito.adapters.outbound.repositories.impl;

import com.financeiro.motor_credito.adapters.outbound.entities.JpaScoreEntity;
import com.financeiro.motor_credito.adapters.outbound.repositories.JpaScoreRepository;
import com.financeiro.motor_credito.domain.model.Score;
import com.financeiro.motor_credito.domain.repository.ScoreRepository;
import com.financeiro.motor_credito.utils.mappers.ScoreMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Score Repository
 * - Adapter
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-07
 */
@Component
public class ScoreRepositoryAdapter implements ScoreRepository {

    private final JpaScoreRepository repository;

    private final ScoreMapper mapper;

    public ScoreRepositoryAdapter(JpaScoreRepository jpaScoreRepository, ScoreMapper mapper) {
        this.repository = jpaScoreRepository;
        this.mapper = mapper;
    }

    @Override
    public Score save(Score score) {
        JpaScoreEntity jpaScoreEntity = mapper.scoreToJpaScore(score);
        this.repository.save(jpaScoreEntity);
        return mapper.jpaToScore(jpaScoreEntity);
    }

    @Override
    public List<Score> findAllByClientId(Long clientId) {
        return null; //this.repository.findAll();
    }
}
