package com.competition.competition.service;

import com.competition.competition.dto.cardrequest.CardRequest;
import com.competition.competition.entity.Expansion;
import com.competition.competition.entity.card.Card;
import com.competition.competition.entity.card.EnergyCard;
import com.competition.competition.entity.card.PokemonCard;
import com.competition.competition.entity.card.TrainerCard;
import com.competition.competition.repository.CardRepository;
import com.competition.competition.repository.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ExpansionRepository expansionRepository;

    public Card createCard(CardRequest cardRequest) {
        Card card;

        switch (cardRequest.getCardType()) {
            case POKEMON -> card = createPokemonCard(cardRequest);
            case TRAINER -> card = createTrainerCard(cardRequest);
            case ENERGY -> card = createEnergyCard(cardRequest);
            default -> throw new IllegalArgumentException("Unknown card type: " + cardRequest.getCardType());
        };

        return cardRepository.save(card);
    }

    private Card createPokemonCard(CardRequest cardRequest) {
        PokemonCard pokemonCard = new PokemonCard();
        updatePokemonCard(pokemonCard, cardRequest);
        return pokemonCard;
    }

    private Card createTrainerCard(CardRequest cardRequest) {
        TrainerCard trainerCard = new TrainerCard();
        updateTrainerCard(trainerCard, cardRequest);
        return trainerCard;
    }

    private Card createEnergyCard(CardRequest cardRequest) {
        EnergyCard energyCard = new EnergyCard();
        updateEnergyCard(energyCard, cardRequest);
        return energyCard;
    }

    private void updatePokemonCard(PokemonCard pokemonCard, CardRequest cardRequest) {
        updateCommonFields(pokemonCard, cardRequest);
        pokemonCard.setAbility(cardRequest.getAbility());
        pokemonCard.setPokemonCardType(cardRequest.getPokemonCardType());
        pokemonCard.setHp(cardRequest.getHp());
        pokemonCard.setRetreatCost(cardRequest.getRetreatCost());
        pokemonCard.setWeakness(cardRequest.getWeakness());
        pokemonCard.setResistance(cardRequest.getResistance());
        pokemonCard.setEnergyType(cardRequest.getEnergyType());
        pokemonCard.setAttackEnergyType(cardRequest.getAttackEnergyType());
    }

    private void updateEnergyCard(EnergyCard energyCard, CardRequest cardRequest) {
        updateCommonFields(energyCard, cardRequest);
        energyCard.setEnergyType(cardRequest.getEnergyType());
        energyCard.setEnergyCardType(cardRequest.getEnergyCardType());
    }

    private void updateTrainerCard(TrainerCard trainerCard, CardRequest cardRequest) {
        updateCommonFields(trainerCard, cardRequest);
        trainerCard.setTrainerCardType(cardRequest.getTrainerCardType());
    }

    private void updateCommonFields(Card card, CardRequest cardRequest) {
        Expansion expansion = expansionRepository.findById(cardRequest.getExpansionId()).orElseThrow(() -> new RuntimeException("Expansion not found"));

        card.setName(cardRequest.getName());
        card.setCardType(cardRequest.getCardType());
        card.setExpansion(expansion);
        card.setArtist(cardRequest.getArtist());
        card.setFormat(cardRequest.getFormat());
        card.setPicUrl(cardRequest.getPicUrl());
        card.setPrice(cardRequest.getPrice());
        card.setRarity(cardRequest.getRarity());
    }
}
