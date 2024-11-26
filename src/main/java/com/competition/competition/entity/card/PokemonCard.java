package com.competition.competition.entity.card;

import com.competition.competition.enums.EnergyType;
import com.competition.competition.enums.PokemonCardType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class PokemonCard extends Card {

    private Boolean ability;
    private Integer hp;
    private Integer retreatCost;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "pokemon_card_subtypes", joinColumns = @JoinColumn(name= "pokemon_card_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "subtypes")
    private List<PokemonCardType> pokemonCardTypes;

    @Enumerated(EnumType.STRING)
    private EnergyType energyType;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "pokemon_card_attackEnergyTypes", joinColumns = @JoinColumn(name= "pokemon_card_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "attack_energy_types")
    private List<EnergyType> attackEnergyTypes;

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

    public EnergyType getEnergyType() {
        return energyType;
    }

    public void setEnergyType(EnergyType energyType) {
        this.energyType = energyType;
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

    public List<PokemonCardType> getPokemonCardTypes() {
        return pokemonCardTypes;
    }

    public void setPokemonCardTypes(List<PokemonCardType> pokemonCardTypes) {
        this.pokemonCardTypes = pokemonCardTypes;
    }

    public List<EnergyType> getAttackEnergyTypes() {
        return attackEnergyTypes;
    }

    public void setAttackEnergyTypes(List<EnergyType> attackEnergyTypes) {
        this.attackEnergyTypes = attackEnergyTypes;
    }
}