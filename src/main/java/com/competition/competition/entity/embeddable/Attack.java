package com.competition.competition.entity.embeddable;

import com.competition.competition.enums.EnergyType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.List;

@Embeddable
public class Attack {
    private String name;
    private String text;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<EnergyType> cost;
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

    public List<EnergyType> getCost() {
        return cost;
    }

    public void setCost(List<EnergyType> cost) {
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
