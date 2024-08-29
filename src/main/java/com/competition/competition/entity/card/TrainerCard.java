package com.competition.competition.entity.card;

import com.competition.competition.enums.TrainerCardType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class TrainerCard extends Card {

    @Enumerated(EnumType.STRING)
    private TrainerCardType trainerCardType;

    public TrainerCardType getTrainerCardType() {
        return trainerCardType;
    }

    public void setTrainerCardType(TrainerCardType trainerCardType) {
        this.trainerCardType = trainerCardType;
    }
}