package com.competition.competition.dto;

import com.competition.competition.entity.embeddable.CardImages;
import com.competition.competition.entity.embeddable.Legalities;
import com.competition.competition.enums.*;

import java.util.List;

public class CardResponseDTO {
    private String name;
    private Integer hp;
    private String artist;
    private String regulationMark;
    private Double price;
    private Double marketPrice;
    private List<String> rules;
    private String expansionId; // Reference to the expansion by ID
    private String identifier;
    private Integer cardNumber;
    private Rarity rarity;
    private SuperType superType;
    private CardImages cardImages; // Embedded field
    private Legalities legalities; // Embedded field
    private List<EnergyType> energyTypes; // Energy types the card can use
    private List<SubType> subTypes;
    private List<EnergyType> attackEnergyTypes;
    private List<EnergyType> weakness;
    private List<EnergyType> resistance;
    private Integer nationalPokedexNumber;
    private Integer retreatCost;
    private boolean hasRuleBox;
    private boolean hasAbility;
    private String ability;
    private String trainerCardText;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRegulationMark() {
        return regulationMark;
    }

    public void setRegulationMark(String regulationMark) {
        this.regulationMark = regulationMark;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public List<String> getRules() {
        return rules;
    }

    public void setRules(List<String> rules) {
        this.rules = rules;
    }

    public String getExpansionId() {
        return expansionId;
    }

    public void setExpansionId(String expansionId) {
        this.expansionId = expansionId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public SuperType getCardType() {
        return superType;
    }

    public void setCardType(SuperType superType) {
        this.superType = superType;
    }

    public CardImages getCardImages() {
        return cardImages;
    }

    public void setCardImages(CardImages cardImages) {
        this.cardImages = cardImages;
    }

    public Legalities getLegalities() {
        return legalities;
    }

    public void setLegalities(Legalities legalities) {
        this.legalities = legalities;
    }

    public List<EnergyType> getEnergyTypes() {
        return energyTypes;
    }

    public void setEnergyTypes(List<EnergyType> energyTypes) {
        this.energyTypes = energyTypes;
    }

    public List<SubType> getPokemonCardTypes() {
        return subTypes;
    }

    public void setPokemonCardTypes(List<SubType> subTypes) {
        this.subTypes = subTypes;
    }

    public List<EnergyType> getAttackEnergyTypes() {
        return attackEnergyTypes;
    }

    public void setAttackEnergyTypes(List<EnergyType> attackEnergyTypes) {
        this.attackEnergyTypes = attackEnergyTypes;
    }

    public List<EnergyType> getWeakness() {
        return weakness;
    }

    public void setWeakness(List<EnergyType> weakness) {
        this.weakness = weakness;
    }

    public List<EnergyType> getResistance() {
        return resistance;
    }

    public void setResistance(List<EnergyType> resistance) {
        this.resistance = resistance;
    }

    public Integer getNationalPokedexNumber() {
        return nationalPokedexNumber;
    }

    public void setNationalPokedexNumber(Integer nationalPokedexNumber) {
        this.nationalPokedexNumber = nationalPokedexNumber;
    }

    public Integer getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(Integer retreatCost) {
        this.retreatCost = retreatCost;
    }

    public boolean isHasRuleBox() {
        return hasRuleBox;
    }

    public void setHasRuleBox(boolean hasRuleBox) {
        this.hasRuleBox = hasRuleBox;
    }

    public boolean isHasAbility() {
        return hasAbility;
    }

    public void setHasAbility(boolean hasAbility) {
        this.hasAbility = hasAbility;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getTrainerCardText() {
        return trainerCardText;
    }

    public void setTrainerCardText(String trainerCardText) {
        this.trainerCardText = trainerCardText;
    }

    public SuperType getSuperType() {
        return superType;
    }

    public void setSuperType(SuperType superType) {
        this.superType = superType;
    }

    public List<SubType> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(List<SubType> subTypes) {
        this.subTypes = subTypes;
    }
}
