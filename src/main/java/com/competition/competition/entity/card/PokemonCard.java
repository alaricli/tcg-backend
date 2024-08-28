package com.competition.competition.entity.card;

import com.competition.competition.enums.EnergyType;
import com.competition.competition.enums.PokemonCardType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
public class PokemonCard extends Card {

    private Boolean ability;
    private Integer hp;
    private Integer retreatCost;

    @Enumerated(EnumType.STRING)
    private PokemonCardType pokemonCardType;

    @Enumerated(EnumType.STRING)
    private EnergyType energyType;

    @Enumerated(EnumType.STRING)
    private EnergyType attackEnergyType;

    @Enumerated(EnumType.STRING)
    private EnergyType weakness;

    @Enumerated(EnumType.STRING)
    private EnergyType resistance;

    public Boolean getAbility() {
        return ability;
    }

    public void setAbility(Boolean ability) {
        this.ability = ability;
    }

    public PokemonCardType getPokemonCardType() {
        return pokemonCardType;
    }

    public void setPokemonCardType(PokemonCardType pokemonCardType) {
        this.pokemonCardType = pokemonCardType;
    }

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
    }

    public EnergyType getAttackEnergyType() {
        return attackEnergyType;
    }

    public void setAttackEnergyType(EnergyType attackEnergyType) {
        this.attackEnergyType = attackEnergyType;
    }

    public EnergyType getWeakness() {
        return weakness;
    }

    public void setWeakness(EnergyType weakness) {
        this.weakness = weakness;
    }

    public EnergyType getResistance() {
        return resistance;
    }

    public void setResistance(EnergyType resistance) {
        this.resistance = resistance;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(Integer retreatCost) {
        this.retreatCost = retreatCost;
    }
}