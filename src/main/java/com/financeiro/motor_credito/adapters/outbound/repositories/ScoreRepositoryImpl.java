package com.financeiro.motor_credito.adapters.outbound.repositories;

import com.financeiro.motor_credito.adapters.outbound.entities.JpaScoreEntity;
import com.financeiro.motor_credito.domain.score.Score;
import com.financeiro.motor_credito.domain.score.ScoreRepository;
import com.financeiro.motor_credito.utils.mappers.ScoreMapper;
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

    private final ScoreMapper mapper;

    public ScoreRepositoryImpl(JpaScoreRepository jpaScoreRepository, ScoreMapper mapper) {
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
