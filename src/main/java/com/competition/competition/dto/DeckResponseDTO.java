package com.competition.competition.dto;

import com.competition.competition.entity.Archetype;

import java.util.List;

public class DeckResponseDTO {
    private Long id;
    private Long archetypeId;
    private String name;
    private String author;
    private Float totalPrice;
    private List<DeckCardResponseDTO> cards;

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
}
