package com.competition.competition.dto;

import com.competition.competition.entity.embeddable.Attack;
import com.competition.competition.entity.embeddable.CardImages;
import com.competition.competition.entity.embeddable.Legalities;
import com.competition.competition.entity.embeddable.PullRates;

import java.util.List;

public class CardRequestDTO {
    private String id;
    private String name;
    private Integer hp;
    private String artist;
    private String regulationMark;
    private Double price;
    private Double marketPrice;
    private List<String> rules;
    private String expansionId; // Reference to the expansion by ID
    private Integer cardNumber;
    private String rarity;
    private String superType;
    private List<String> subTypes;
    private CardImages cardImages; // Embedded field
    private Legalities legalities; // Embedded field
    private PullRates pullRates;
    private List<String> energyTypes; // Energy types the card can use
    private List<Attack> attacks;
    private List<String> attackEnergyTypes;
    private List<String> weakness;
    private List<String> resistance;
    private List<String> foundInPacks;
    private Integer nationalPokedexNumber;
    private Integer retreatCost;
    private boolean hasRuleBox;
    private boolean hasAbility;
    private boolean isPocket;
    private String ability;
    private String trainerCardText;
    private Integer dustCost;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSuperType() {
        return superType;
    }

    public void setSuperType(String superType) {
        this.superType = superType;
    }

    public List<String> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(List<String> subTypes) {
        this.subTypes = subTypes;
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

    public List<String> getEnergyTypes() {
        return energyTypes;
    }

    public void setEnergyTypes(List<String> energyTypes) {
        this.energyTypes = energyTypes;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public List<String> getAttackEnergyTypes() {
        return attackEnergyTypes;
    }

    public void setAttackEnergyTypes(List<String> attackEnergyTypes) {
        this.attackEnergyTypes = attackEnergyTypes;
    }

    public List<String> getWeakness() {
        return weakness;
    }

    public void setWeakness(List<String> weakness) {
        this.weakness = weakness;
    }

    public List<String> getResistance() {
        return resistance;
    }

    public void setResistance(List<String> resistance) {
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

    public PullRates getPullRates() {
        return pullRates;
    }

    public void setPullRates(PullRates pullRates) {
        this.pullRates = pullRates;
    }

    public boolean isPocket() {
        return isPocket;
    }

    public void setPocket(boolean pocket) {
        isPocket = pocket;
    }

    public Integer getDustCost() {
        return dustCost;
    }

    public void setDustCost(Integer dustCost) {
        this.dustCost = dustCost;
    }

    public List<String> getFoundInPacks() {
        return foundInPacks;
    }

    public void setFoundInPacks(List<String> foundInPacks) {
        this.foundInPacks = foundInPacks;
    }
}
