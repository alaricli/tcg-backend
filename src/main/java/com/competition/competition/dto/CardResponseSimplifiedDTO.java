package com.competition.competition.dto;

import com.competition.competition.entity.embeddable.CardImages;

public class CardResponseSimplifiedDTO {
    private String id;
    private String name;
    private CardImages cardImages; // Embedded field

    public CardResponseSimplifiedDTO(String id, String name, String smallImage) {
        this.id = id;
        this.name = name;
        this.cardImages = new CardImages();
        this.cardImages.setSmall(smallImage);
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
}
