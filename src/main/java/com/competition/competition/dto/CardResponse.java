package com.competition.competition.dto;

import com.competition.competition.enums.*;

import java.util.List;

public class CardResponse {
    private Long id;
    private String name;
    private Integer hp;
    private Integer retreatCost;
    private String artist;
    private String picUrl;
    private Boolean ability;
    private Float price;
    private CardType cardType;
    private PokemonCardType pokemonCardType;
    private TrainerCardType trainerCardType;
    private EnergyCardType energyCardType;
    private EnergyType energyType;
    private EnergyType attackEnergyType;
    private EnergyType weakness;
    private EnergyType resistance;
    private Rarity rarity;
    private Format format;
    private List<Long> deckIds;
    private String expansionName;
    private Series expansionSeries;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public List<Long> getDeckIds() {
        return deckIds;
    }

    public void setDeckIds(List<Long> deckIds) {
        this.deckIds = deckIds;
    }

    public String getExpansionName() {
        return expansionName;
    }

    public void setExpansionName(String expansionName) {
        this.expansionName = expansionName;
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

    public TrainerCardType getTrainerCardType() {
        return trainerCardType;
    }

    public void setTrainerCardType(TrainerCardType trainerCardType) {
        this.trainerCardType = trainerCardType;
    }

    public EnergyCardType getEnergyCardType() {
        return energyCardType;
    }

    public void setEnergyCardType(EnergyCardType energyCardType) {
        this.energyCardType = energyCardType;
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

    public Series getExpansionSeries() {
        return expansionSeries;
    }

    public void setExpansionSeries(Series expansionSeries) {
        this.expansionSeries = expansionSeries;
    }
}
