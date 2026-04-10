package com.financeiro.motor_credito.utils.mappers;

import com.financeiro.motor_credito.adapters.outbound.entities.JpaScoreEntity;
import com.financeiro.motor_credito.domain.score.Score;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * Score Mappers
 * @author Luciano R. Cardoso
 * @since 2026-04-09
 */
@Mapper(componentModel = "spring")
public interface ScoreMapper {

    @Mappings({
            @Mapping(source = "score.scoreId", target = "scoreId"),
            @Mapping(source = "score.client", target = "client"),
            @Mapping(source = "score.scorePoints", target = "scorePoints"),
            @Mapping(source = "score.actualIncome", target = "actualIncome"),
            @Mapping(source = "score.restrict", target = "isRestrict"),
            @Mapping(source = "score.searchDate", target = "searchDate"),
            @Mapping(source = "score.result", target = "result"),
            @Mapping(source = "score.description", target = "description"),
    })
    JpaScoreEntity scoreToJpaScore(Score score);

    @Mappings({
            @Mapping(source = "jpa.scoreId", target = "scoreId"),
            @Mapping(source = "jpa.client", target = "client"),
            @Mapping(source = "jpa.scorePoints", target = "scorePoints"),
            @Mapping(source = "jpa.actualIncome", target = "actualIncome"),
            @Mapping(source = "jpa.isRestrict", target = "restrict"),
            @Mapping(source = "jpa.searchDate", target = "searchDate"),
            @Mapping(source = "jpa.result", target = "result"),
            @Mapping(source = "jpa.description", target = "description"),
    })
    Score jpaToScore(JpaScoreEntity jpa);

}
