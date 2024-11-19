package com.competition.competition.dto.cardresponse;

import com.competition.competition.enums.TrainerCardType;

public class TrainerCardResponse extends CardResponse {
    private TrainerCardType trainerCardType;

    public TrainerCardType getTrainerCardType() {
        return trainerCardType;
    }

    public void setTrainerCardType(TrainerCardType trainerCardType) {
        this.trainerCardType = trainerCardType;
    }
}
