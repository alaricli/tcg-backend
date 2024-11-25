package com.competition.competition.dto.cardresponse;

import com.competition.competition.entity.card.TrainerCard;
import com.competition.competition.enums.TrainerCardType;

import java.util.List;

public class TrainerCardResponse extends CardResponse {
    private List<TrainerCard> trainerCards;

    public List<TrainerCard> getTrainerCards() {
        return trainerCards;
    }

    public void setTrainerCards(List<TrainerCard> trainerCards) {
        this.trainerCards = trainerCards;
    }
}
