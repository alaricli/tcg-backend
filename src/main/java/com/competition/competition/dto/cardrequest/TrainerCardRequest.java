package com.competition.competition.dto.cardrequest;

import com.competition.competition.enums.TrainerCardType;

public class TrainerCardRequest extends CardRequest {
    private TrainerCardType trainerCardType;

    public TrainerCardType getTrainerCardType() {
        return trainerCardType;
    }

    public void setTrainerCardType(TrainerCardType trainerCardType) {
        this.trainerCardType = trainerCardType;
    }
}
