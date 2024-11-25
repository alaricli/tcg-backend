package com.competition.competition.entity.card;

import com.competition.competition.entity.Deck;
import com.competition.competition.entity.Expansion;
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
    private String name;
    private String artist;
    private String picUrl;
    private Float price;
    private Integer cardNumber;

    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Enumerated(EnumType.STRING)
    private Rarity rarity;

    @Enumerated(EnumType.STRING)
    private Format format;

    @ManyToOne
    @JoinColumn(name = "expansion_id", nullable = false)
//    @JsonIgnore
    private Expansion expansion;

    @ManyToMany(mappedBy = "cards")
    private List<Deck> decks;

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

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }
}