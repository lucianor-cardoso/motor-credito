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
    @Column(name = "id_score")
    private Integer idScore;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private JpaClientEntity client;

    @Column(name = "score_points")
    private Integer scorePoints;

    @Column(name = "actual_income", precision = 11, scale = 2)
    private BigDecimal actualIncome;

    @Column(name = "is_restrict")
    @Convert(converter = BooleanToStringConverter.class)
    private boolean isRestrict;

    @Column(name = "seach_date")
    private LocalDateTime searchDate;

    @Column(name = "result")
    private String result;

    @Column(name = "result_description")
    private String description;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        JpaScoreEntity that = (JpaScoreEntity) o;
        return isRestrict == that.isRestrict
                && Objects.equals(idScore, that.idScore)
                && Objects.equals(client, that.client)
                && Objects.equals(scorePoints, that.scorePoints)
                && Objects.equals(actualIncome, that.actualIncome)
                && Objects.equals(searchDate, that.searchDate);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = Objects.hashCode(idScore);
        result = prime * result + Objects.hashCode(client);
        result = prime * result + Objects.hashCode(scorePoints);
        result = prime * result + Objects.hashCode(actualIncome);
        result = prime * result + Boolean.hashCode(isRestrict);
        result = prime * result + Objects.hashCode(searchDate);
        return result;
    }

    @Override
    public String toString() {
        return "JpaScoreEntity{" +
                "idScore=" + idScore +
                ", client=" + client +
                ", scorePoints=" + scorePoints +
                ", actualIncome=" + actualIncome +
                ", isRestrict=" + isRestrict +
                ", searchDate=" + searchDate +
                '}';
    }
}
