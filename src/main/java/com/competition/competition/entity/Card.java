package com.competition.competition.entity;

import com.competition.competition.entity.embeddable.Attack;
import com.competition.competition.entity.embeddable.CardImages;
import com.competition.competition.entity.embeddable.Legalities;
import com.competition.competition.enums.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "card")
public class Card {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Common Information
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
    @Column(unique = true)
    private String identifier;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "expansion_id")
    private Expansion expansion;
    private Integer cardNumber;
    @Enumerated(EnumType.STRING)
    private Rarity rarity;
    @Embedded
    private CardImages cardImages;
    @Embedded
    private Legalities legalities;
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    // Pokemon + Energy Information
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "energy_types", joinColumns = @JoinColumn(name = "card_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "energy_types")
    private List<EnergyType> energyType;

    // Pokemon Information
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "pokemon_card_subtypes", joinColumns = @JoinColumn(name = "card_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "subtypes")
    private List<PokemonCardType> pokemonCardTypes;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "attack_energy_types", joinColumns = @JoinColumn(name = "card_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "attack_energy_types")
    private List<EnergyType> attackEnergyTypes;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "attacks", joinColumns = @JoinColumn(name = "card_id"))
    private List<Attack> attacks;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "weakness_types", joinColumns = @JoinColumn(name = "card_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "weakness_types")
    private List<EnergyType> weakness;
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "resistance_types", joinColumns = @JoinColumn(name = "card_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "resistance_types")
    private List<EnergyType> resistance;
    private Integer retreatCost;
    private Integer nationalPokedexNumber;
    private boolean hasRuleBox;
    private boolean hasAbility;
    private String ability;

    // Trainer Information
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "trainer_card_subtypes", joinColumns = @JoinColumn(name = "card_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "subtypes")
    private List<TrainerCardType> trainerCardTypes;
    private String trainerCardText;

    // Energy Information
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "energy_card_subtypes", joinColumns = @JoinColumn(name = "card_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "subtypes")
    private List<EnergyCardType> energyCardTypes;

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

    public Integer getNationalPokedexNumber() {
        return nationalPokedexNumber;
    }

    public void setNationalPokedexNumber(Integer nationalPokedexNumber) {
        this.nationalPokedexNumber = nationalPokedexNumber;
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

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Expansion getExpansion() {
        return expansion;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = expansion;
    }

    public List<PokemonCardType> getPokemonCardTypes() {
        return pokemonCardTypes;
    }

    public void setPokemonCardTypes(List<PokemonCardType> pokemonCardTypes) {
        this.pokemonCardTypes = pokemonCardTypes;
    }

    public List<EnergyCardType> getEnergyCardTypes() {
        return energyCardTypes;
    }

    public void setEnergyCardTypes(List<EnergyCardType> energyCardTypes) {
        this.energyCardTypes = energyCardTypes;
    }

    public List<TrainerCardType> getTrainerCardTypes() {
        return trainerCardTypes;
    }

    public void setTrainerCardTypes(List<TrainerCardType> trainerCardTypes) {
        this.trainerCardTypes = trainerCardTypes;
    }

    public List<EnergyType> getEnergyType() {
        return energyType;
    }

    public void setEnergyType(List<EnergyType> energyType) {
        this.energyType = energyType;
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

    public List<String> getRules() {
        return rules;
    }

    public void setRules(List<String> rules) {
        this.rules = rules;
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

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }
}