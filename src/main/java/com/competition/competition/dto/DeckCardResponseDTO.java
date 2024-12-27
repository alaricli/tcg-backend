package com.competition.competition.dto;

public class DeckCardResponseDTO {
    private String cardId;
    private Integer cardQuantity;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Integer getCardQuantity() {
        return cardQuantity;
    }

    public void setCardQuantity(Integer cardQuantity) {
        this.cardQuantity = cardQuantity;
    }
}
