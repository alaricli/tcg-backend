package com.competition.competition.entity;

import com.competition.competition.entity.embeddable.Attack;
import com.competition.competition.entity.embeddable.CardImages;
import com.competition.competition.entity.embeddable.Legalities;
import com.competition.competition.entity.embeddable.PullRates;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    private Integer hp;
    private String artist;
    private String regulationMark;
    private Double price;
    private Double marketPrice;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "rules", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "rules")
    private List<String> rules;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "expansion_id")
    private Expansion expansion;
    private Integer cardNumber;
    private String rarity;
    @Embedded
    private CardImages cardImages;
    @Embedded
    private Legalities legalities;
    @Embedded
    private PullRates pullRates;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "card_pack", // Join table name
            joinColumns = @JoinColumn(name = "card_id"), // Foreign key in join table referencing `Card`
            inverseJoinColumns = @JoinColumn(name = "pack_id") // Foreign key in join table referencing `Pack`
    )
    private List<Pack> foundInPacks;
    private String superType;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "energy_types", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "energy_types")
    private List<String> energyTypes;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "attack_energy_types", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "attack_energy_types")
    private List<String> attackEnergyTypes;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "attacks", joinColumns = @JoinColumn(name = "card_id"))
    private List<Attack> attacks;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "weakness_types", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "weakness_types")
    private List<String> weakness;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "resistance_types", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "resistance_types")
    private List<String> resistance;
    private Integer retreatCost;
    private Integer nationalPokedexNumber;
    private String description;
    private Boolean hasRuleBox;
    private Boolean hasAbility;
    private Boolean isPocket;
    @Column(length = 1000)
    private String ability;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "card_subtypes", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "subtypes")
    private List<String> subTypes;
    @Column(length = 1000)
    private String trainerCardText;
    private Integer dustCost;

    public Integer getDustCost() {
        return dustCost;
    }

    public void setDustCost(Integer dustCost) {
        this.dustCost = dustCost;
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

    public Expansion getExpansion() {
        return expansion;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = expansion;
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

    public String getSuperType() {
        return superType;
    }

    public void setSuperType(String superType) {
        this.superType = superType;
    }

    public List<String> getEnergyTypes() {
        return energyTypes;
    }

    public void setEnergyTypes(List<String> energyTypes) {
        this.energyTypes = energyTypes;
    }

    public List<String> getAttackEnergyTypes() {
        return attackEnergyTypes;
    }

    public void setAttackEnergyTypes(List<String> attackEnergyTypes) {
        this.attackEnergyTypes = attackEnergyTypes;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
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

    public Integer getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(Integer retreatCost) {
        this.retreatCost = retreatCost;
    }

    public Integer getNationalPokedexNumber() {
        return nationalPokedexNumber;
    }

    public void setNationalPokedexNumber(Integer nationalPokedexNumber) {
        this.nationalPokedexNumber = nationalPokedexNumber;
    }

    public Boolean isHasRuleBox() {
        return hasRuleBox;
    }

    public void setHasRuleBox(Boolean hasRuleBox) {
        this.hasRuleBox = hasRuleBox;
    }

    public Boolean isHasAbility() {
        return hasAbility;
    }

    public void setHasAbility(Boolean hasAbility) {
        this.hasAbility = hasAbility;
    }

    public boolean isPocket() {
        return isPocket;
    }

    public void setPocket(boolean pocket) {
        isPocket = pocket;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public List<String> getSubTypes() {
        return subTypes;
    }

    public void setSubTypes(List<String> subTypes) {
        this.subTypes = subTypes;
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

    public List<Pack> getFoundInPacks() {
        return foundInPacks;
    }

    public void setFoundInPacks(List<Pack> foundInPacks) {
        this.foundInPacks = foundInPacks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}