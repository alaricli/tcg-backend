package com.competition.competition.entity.card;

import com.competition.competition.enums.TrainerCardType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class TrainerCard extends Card {

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "trainer_card_subtypes", joinColumns = @JoinColumn(name= "trainer_card_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "subtypes")
    private List<TrainerCardType> trainerCardTypes;

    public List<TrainerCardType> getTrainerCardTypes() {
        return trainerCardTypes;
    }

    public void setTrainerCardTypes(List<TrainerCardType> trainerCardTypes) {
        this.trainerCardTypes = trainerCardTypes;
    }
}