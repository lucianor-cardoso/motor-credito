package com.financeiro.motor_credito.domain.model;

/**
 * Credit Data
 * - Store info from Credit Service Bureau, later,
 * the information will be moved to Score object.
 *
 * @author Luciano R. Cardoso
 * @since 2026-04-14
 */
public class CreditData {
    private Integer score;
    private boolean isRestrict;

    public CreditData() {
    }

    public CreditData(Integer score, boolean isRestrict) {
        this.score = score;
        this.isRestrict = isRestrict;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public boolean isRestrict() {
        return isRestrict;
    }

    public void setRestrict(boolean restrict) {
        isRestrict = restrict;
    }

}
