package com.competition.competition.dto.cardresponse;

import com.competition.competition.enums.EnergyType;
import com.competition.competition.enums.PokemonCardType;

public class PokemonCardResponse extends CardResponse {
    private Boolean ability;
    private Integer hp;
    private Integer retreatCost;
    private PokemonCardType pokemonCardType;
    private EnergyType energyType;
    private EnergyType attackEnergyType;
    private EnergyType weakness;
    private EnergyType resistance;

    public Boolean getAbility() {
        return ability;
    }

    public void setAbility(Boolean ability) {
        this.ability = ability;
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
}
