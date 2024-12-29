package com.competition.competition.dto;

import java.util.List;

public class DeckResponseDTO {
    private Long id;
    private Long archetypeId;
    private String name;
    private String author;
    private Float totalPrice;
    private String image;
    private String description;
    private String variant;
    private List<String> variant_pokemons;
    private List<String> variant_pokemons_images;
    private List<DeckCardResponseDTO> cards;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArchetypeId() {
        return archetypeId;
    }

    public void setArchetypeId(Long archetypeId) {
        this.archetypeId = archetypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<DeckCardResponseDTO> getCards() {
        return cards;
    }

    public void setCards(List<DeckCardResponseDTO> cards) {
        this.cards = cards;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public List<String> getVariant_pokemons() {
        return variant_pokemons;
    }

    public void setVariant_pokemons(List<String> variant_pokemons) {
        this.variant_pokemons = variant_pokemons;
    }

    public List<String> getVariant_pokemons_images() {
        return variant_pokemons_images;
    }

    public void setVariant_pokemons_images(List<String> variant_pokemons_images) {
        this.variant_pokemons_images = variant_pokemons_images;
    }
}
