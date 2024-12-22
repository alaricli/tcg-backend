package com.competition.competition.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Archetype {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String tier;
    private Integer ranking;
    private Float share;
    private Integer wins;
    private String image;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "archetype_pokemons", joinColumns = @JoinColumn(name = "archetype_id"))
    @Column(name = "archetype_pokemons")
    private List<String> pokemons;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "archetype_pokemonsImages", joinColumns = @JoinColumn(name = "archetype_id"))
    @Column(name = "archetype_pokemonsImages")
    private List<String> pokemonsImages;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "archetype_energy_types", joinColumns = @JoinColumn(name = "card_id"))
    @Column(name = "archetype_energy_types")
    private List<String> energyTypes;

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

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Float getShare() {
        return share;
    }

    public void setShare(Float share) {
        this.share = share;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<String> pokemons) {
        this.pokemons = pokemons;
    }

    public List<String> getPokemonsImages() {
        return pokemonsImages;
    }

    public void setPokemonsImages(List<String> pokemonsImages) {
        this.pokemonsImages = pokemonsImages;
    }

    public List<String> getEnergyTypes() {
        return energyTypes;
    }

    public void setEnergyTypes(List<String> energyTypes) {
        this.energyTypes = energyTypes;
    }
}
