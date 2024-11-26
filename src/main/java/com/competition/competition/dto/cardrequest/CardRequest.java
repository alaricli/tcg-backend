package com.competition.competition.dto.cardrequest;

import com.competition.competition.enums.*;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.bean.CsvCustomBindByName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardRequest {
    private Long id;
    private String name;
    private Integer hp;
    private Integer retreatCost;
    private String artist;
    private String picUrl;
    private Boolean ability;
    private Float price;
    private CardType cardType;
    @CsvCustomBindByName(column = "pokemonCardTypes", converter = CardRequest.PokemonCardTypeConverter.class)
    private List<PokemonCardType> pokemonCardTypes;
    @CsvCustomBindByName(column = "trainerCardTypes", converter = CardRequest.TrainerCardTypeConverter.class)
    private List<TrainerCardType> trainerCardTypes;
    @CsvCustomBindByName(column = "energyCardTypes", converter = CardRequest.EnergyCardTypeConverter.class)
    private List<EnergyCardType> energyCardTypes;
    private EnergyType energyType;
    @CsvCustomBindByName(column = "attackEnergyTypes", converter = CardRequest.AttackEnergyTypeConverter.class)
    private List<EnergyType> attackEnergyTypes;
    private EnergyType weakness;
    private EnergyType resistance;
    private Rarity rarity;
    private Format format;
    private List<Long> deckIds;
    private Long expansionId;
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

    public List<Long> getDeckIds() {
        return deckIds;
    }

    public void setDeckIds(List<Long> deckIds) {
        this.deckIds = deckIds;
    }

    public Long getExpansionId() {
        return expansionId;
    }

    public void setExpansionId(Long expansionId) {
        this.expansionId = expansionId;
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

    public CardType getSuperType() {
        return cardType;
    }

    public void setSuperType(CardType cardType) {
        this.cardType = cardType;
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

    public List<EnergyType> getAttackEnergyTypes() {
        return attackEnergyTypes;
    }

    public void setAttackEnergyTypes(List<EnergyType> attackEnergyTypes) {
        this.attackEnergyTypes = attackEnergyTypes;
    }

    public static class PokemonCardTypeConverter extends AbstractBeanField<List<PokemonCardType>, String> {
        @Override
        protected Object convert(String value) {
            if (value == null || value.isEmpty()) {
                return new ArrayList<>();
            }
            return Arrays.stream(value.split(","))
                    .map(String::trim)
                    .map(PokemonCardType::valueOf)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        }
    }

    public static class TrainerCardTypeConverter extends AbstractBeanField<List<TrainerCardType>, String> {
        @Override
        protected Object convert(String value) {
            if (value == null || value.isEmpty()) {
                return new ArrayList<>();
            }
            return Arrays.stream(value.split(","))
                    .map(String::trim)
                    .map(TrainerCardType::valueOf)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        }
    }

    public static class EnergyCardTypeConverter extends AbstractBeanField<List<EnergyCardType>, String> {
        @Override
        protected Object convert(String value) {
            if (value == null || value.isEmpty()) {
                return new ArrayList<>();
            }
            return Arrays.stream(value.split(","))
                    .map(String::trim)
                    .map(EnergyCardType::valueOf)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        }
    }

    public static class AttackEnergyTypeConverter extends AbstractBeanField<List<EnergyType>, String> {
        @Override
        protected Object convert(String value) {
            if (value == null || value.isEmpty()) {
                return new ArrayList<>();
            }
            return Arrays.stream(value.split(","))
                    .map(String::trim)
                    .map(EnergyType::valueOf)
                    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        }
    }
}
