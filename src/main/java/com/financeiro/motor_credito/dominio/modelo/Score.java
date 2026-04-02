package com.financeiro.motor_credito.dominio.modelo;

import com.financeiro.motor_credito.aplicacao.conversores.BooleanToStringConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Entidade Score
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
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_score")
    private Integer idScore;

    @ManyToOne
    private Cliente cliente;

    @Column(name = "qtd_pontos")
    private Integer pontosScore;

    @Column(name = "vlr_renda_atual", precision = 11, scale = 2)
    private BigDecimal rendaAtual;

    @Column(name = "ind_restricao")
    @Convert(converter = BooleanToStringConverter.class)
    private boolean isRestricao;

    @Column(name = "dat_consulta")
    private final LocalDateTime dataConsulta = LocalDateTime.now();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;
        return isRestricao == score.isRestricao
                && Objects.equals(idScore, score.idScore)
                && Objects.equals(cliente, score.cliente)
                && Objects.equals(pontosScore, score.pontosScore)
                && Objects.equals(rendaAtual, score.rendaAtual)
                && Objects.equals(dataConsulta, score.dataConsulta);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = Objects.hashCode(idScore);
        result = prime * result + Objects.hashCode(cliente);
        result = prime * result + Objects.hashCode(pontosScore);
        result = prime * result + Objects.hashCode(rendaAtual);
        result = prime * result + Boolean.hashCode(isRestricao);
        result = prime * result + Objects.hashCode(dataConsulta);
        return result;
    }

}
