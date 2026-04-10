package com.financeiro.motor_credito.adapters.outbound.entities;

import com.financeiro.motor_credito.application.converters.BooleanToStringConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * JpaScoreEntity
 * A cada consulta ao score, serão atualizadas essas informações,
 * o que seria um contato do cliente para uma análise de aprovação
 * de crédito, seria feita uma atualização do salário seguida de
 * uma consulta do Serasa, o retorno da informação geraria
 * um registro de Score.
 *
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
@Getter
@Setter
@Entity
@Table(name = "score")
public class JpaScoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "score_id")
    private Integer scoreId;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private JpaClientEntity client;

    @Column(name = "score_points")
    private Integer scorePoints;

    @Column(name = "actual_income", precision = 11, scale = 2)
    private BigDecimal actualIncome;

    @Column(name = "is_restrict")
    @Convert(converter = BooleanToStringConverter.class)
    private Boolean isRestrict;

    @Column(name = "seach_date")
    private LocalDateTime searchDate;

    @Column(name = "result")
    private String result;

    @Column(name = "result_description")
    private String description;

    public JpaScoreEntity() {
        // default constructor.
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        JpaScoreEntity that = (JpaScoreEntity) o;
        return Objects.equals(isRestrict, that.isRestrict)
                && Objects.equals(scoreId, that.scoreId)
                && Objects.equals(client, that.client)
                && Objects.equals(scorePoints, that.scorePoints)
                && Objects.equals(actualIncome, that.actualIncome)
                && Objects.equals(searchDate, that.searchDate);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int resultHash = Objects.hashCode(scoreId);
        resultHash = prime * resultHash + Objects.hashCode(client);
        resultHash = prime * resultHash + Objects.hashCode(scorePoints);
        resultHash = prime * resultHash + Objects.hashCode(actualIncome);
        resultHash = prime * resultHash + Boolean.hashCode(isRestrict);
        resultHash = prime * resultHash + Objects.hashCode(searchDate);
        return resultHash;
    }

    @Override
    public String toString() {
        return "JpaScoreEntity{" +
                "idScore=" + scoreId +
                ", client=" + client +
                ", scorePoints=" + scorePoints +
                ", actualIncome=" + actualIncome +
                ", isRestrict=" + isRestrict +
                ", searchDate=" + searchDate +
                '}';
    }
}
