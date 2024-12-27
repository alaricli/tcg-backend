package com.competition.competition.dto;

import com.competition.competition.entity.DeckCard;

import java.util.List;

public class DeckRequestDTO {
    private String name;
    private Long archetypeId;
    private String author;
    private Float totalPrice;
    private List<DeckCard> cards;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getArchetypeId() {
        return archetypeId;
    }

    public void setArchetypeId(Long archetypeId) {
        this.archetypeId = archetypeId;
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

    public List<DeckCard> getCards() {
        return cards;
    }

    public void setCards(List<DeckCard> cards) {
        this.cards = cards;
    }
}
