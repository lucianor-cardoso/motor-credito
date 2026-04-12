package com.financeiro.motor_credito.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Score Object
 * A cada consulta ao score, serão atualizadas essas informações,
 * o que seria um contato do cliente para uma análise de aprovação
 * de crédito, seria feita uma atualização do salário seguida de
 * uma consulta do Serasa, o retorno da informação geraria
 * um registro de Score.
 *
 * @author Luciano R. Cardoso
 * @since 2026-03-31
 */
public class Score {
    private Integer scoreId;
    private Client client;
    private Integer scorePoints;
    private BigDecimal actualIncome;
    private Boolean isRestrict;
    private LocalDateTime searchDate;
    private String result;
    private String description;

    public Score() {
    }

    public Score(Integer scoreId, Client client, Integer scorePoints, BigDecimal actualIncome,
                 Boolean isRestrict, LocalDateTime searchDate, String result, String description) {
        this.scoreId = scoreId;
        this.client = client;
        this.scorePoints = scorePoints;
        this.actualIncome = actualIncome;
        this.isRestrict = isRestrict;
        this.searchDate = searchDate;
        this.result = result;
        this.description = description;
    }

    public Integer getScoreId() {
        return scoreId;
    }

    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getScorePoints() {
        return scorePoints;
    }

    public void setScorePoints(Integer scorePoints) {
        this.scorePoints = scorePoints;
    }

    public BigDecimal getActualIncome() {
        return actualIncome;
    }

    public void setActualIncome(BigDecimal actualIncome) {
        this.actualIncome = actualIncome;
    }

    public Boolean getRestrict() {
        return isRestrict;
    }

    public void setRestrict(Boolean restrict) {
        isRestrict = restrict;
    }

    public LocalDateTime getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(LocalDateTime searchDate) {
        this.searchDate = searchDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;
        return Objects.equals(isRestrict, score.isRestrict)
                && Objects.equals(scoreId, score.scoreId)
                && Objects.equals(client.getClientId(), score.client.getClientId())
                && Objects.equals(scorePoints, score.scorePoints)
                && Objects.equals(actualIncome, score.actualIncome)
                && Objects.equals(searchDate, score.searchDate)
                && Objects.equals(result, score.result)
                && Objects.equals(description, score.description);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result1 = Objects.hashCode(scoreId);
        result1 = prime * result1 + Objects.hashCode(client.getClientId());
        result1 = prime * result1 + Objects.hashCode(scorePoints);
        result1 = prime * result1 + Objects.hashCode(actualIncome);
        result1 = prime * result1 + Boolean.hashCode(isRestrict);
        result1 = prime * result1 + Objects.hashCode(searchDate);
        result1 = prime * result1 + Objects.hashCode(result);
        result1 = prime * result1 + Objects.hashCode(description);
        return result1;
    }

    @Override
    public String toString() {
        return "Score {" +
                "idScore=" + scoreId +
                ", clientId=" + client.getClientId() +
                ", scorePoints=" + scorePoints +
                ", actualIncome=" + actualIncome +
                ", isRestrict=" + isRestrict +
                ", researchDate=" + searchDate +
                ", result='" + result + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
