package com.competition.competition.entity;

import com.competition.competition.enums.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer hp;
    private Integer retreatCost;
    private String name;
    private String artist;
    private String picUrl;
    private Boolean ability;
    private Float price;
    @Enumerated(EnumType.STRING)
    private CardType cardType;
    @Enumerated(EnumType.STRING)
    private PokemonCardType pokemonCardType;
    @Enumerated(EnumType.STRING)
    private TrainerCardType trainerCardType;
    @Enumerated(EnumType.STRING)
    private EnergyCardType energyCardType;
    @Enumerated(EnumType.STRING)
    private EnergyType energyType;
    @Enumerated(EnumType.STRING)
    private EnergyType attackEnergyType;
    @Enumerated(EnumType.STRING)
    private EnergyType weakness;
    @Enumerated(EnumType.STRING)
    private EnergyType resistance;
    @Enumerated(EnumType.STRING)
    private Rarity rarity;
    @Enumerated(EnumType.STRING)
    private Format format;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "expansion_id", nullable = false)
    private Expansion expansion;
    @ManyToMany(mappedBy = "cards")
    private List<Deck> decks;

    public EnergyType getWeakness() {
        return weakness;
    }

    public void setWeakness(EnergyType weakness) {
        this.weakness = weakness;
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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Boolean getAbility() {
        return ability;
    }

    public void setAbility(Boolean ability) {
        this.ability = ability;
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

    public EnergyType getResistance() {
        return resistance;
    }

    public void setResistance(EnergyType resistance) {
        this.resistance = resistance;
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

    public Expansion getExpansion() {
        return expansion;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = expansion;
    }

    public List<Deck> getDecks() {
        return decks;
    }

    public void setDecks(List<Deck> decks) {
        this.decks = decks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}