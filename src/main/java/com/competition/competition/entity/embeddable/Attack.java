package com.competition.competition.entity.embeddable;

import jakarta.persistence.*;

@Embeddable
public class Attack {
    private String name;
    private String text;
    // flattened list of energy cost in one string
    private String cost;
    private Integer numericalEnergyCost;
    private Integer damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Integer getNumericalEnergyCost() {
        return numericalEnergyCost;
    }

    public void setNumericalEnergyCost(Integer numericalEnergyCost) {
        this.numericalEnergyCost = numericalEnergyCost;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }
}
