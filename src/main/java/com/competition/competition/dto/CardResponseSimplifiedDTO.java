package com.competition.competition.dto;

import com.competition.competition.entity.embeddable.Attack;
import com.competition.competition.entity.embeddable.CardImages;
import com.competition.competition.entity.embeddable.Legalities;
import com.competition.competition.entity.embeddable.PullRates;

import java.util.List;

public class CardResponseSimplifiedDTO {
    private String id;
    private String name;
    private CardImages cardImages; // Embedded field
    private Integer dustCost;

    public CardResponseSimplifiedDTO(String id, String name, String smallImage, Integer dust_cost) {
        this.id = id;
        this.name = name;
        this.cardImages = new CardImages();
        this.cardImages.setSmall(smallImage);
        this.dustCost = dust_cost;
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

    public CardImages getCardImages() {
        return cardImages;
    }

    public void setCardImages(CardImages cardImages) {
        this.cardImages = cardImages;
    }

    public Integer getDustCost() {
        return dustCost;
    }

    public void setDustCost(Integer dustCost) {
        this.dustCost = dustCost;
    }
}
