package com.competition.competition.dto.cardresponse;

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
    private List<PokemonCardType> pokemonCardTypes;
    private List<TrainerCardType> trainerCardTypes;
    private List<EnergyCardType> energyCardTypes;
    private EnergyType energyType;
    private List<EnergyType> attackEnergyType;
    private EnergyType weakness;
    private EnergyType resistance;
    private Rarity rarity;
    private Format format;
    private String expansionName;
    private Integer cardNumber;

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

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public List<PokemonCardType> getPokemonCardTypes() {
        return pokemonCardTypes;
    }

    public void setPokemonCardTypes(List<PokemonCardType> pokemonCardTypes) {
        this.pokemonCardTypes = pokemonCardTypes;
    }

    public List<TrainerCardType> getTrainerCardTypes() {
        return trainerCardTypes;
    }

    public void setTrainerCardTypes(List<TrainerCardType> trainerCardTypes) {
        this.trainerCardTypes = trainerCardTypes;
    }

    public List<EnergyCardType> getEnergyCardTypes() {
        return energyCardTypes;
    }

    public void setEnergyCardTypes(List<EnergyCardType> energyCardTypes) {
        this.energyCardTypes = energyCardTypes;
    }
}
