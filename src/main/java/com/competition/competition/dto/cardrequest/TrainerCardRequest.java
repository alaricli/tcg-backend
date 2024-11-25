package com.competition.competition.dto.cardrequest;

import com.competition.competition.enums.TrainerCardType;

import java.util.List;

public class TrainerCardRequest extends CardRequest {
    private List<TrainerCardType> trainerCardTypes;

    public List<TrainerCardType> getTrainerCardTypes() {
        return trainerCardTypes;
    }

    public void setTrainerCardTypes(List<TrainerCardType> trainerCardTypes) {
        this.trainerCardTypes = trainerCardTypes;
    }
}
