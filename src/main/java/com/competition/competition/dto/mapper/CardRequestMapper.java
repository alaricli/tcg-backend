package com.competition.competition.dto.mapper;

import com.competition.competition.dto.cardrequest.CardRequest;
import com.competition.competition.entity.Expansion;
import com.competition.competition.entity.card.Card;
import com.competition.competition.entity.card.EnergyCard;
import com.competition.competition.entity.card.PokemonCard;
import com.competition.competition.entity.card.TrainerCard;
import com.competition.competition.repository.CardRepository;
import com.competition.competition.repository.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardRequestMapper {
    @Autowired
    private ExpansionRepository expansionRepository;

    public Card mapToCard(CardRequest cardRequest) {
        return switch (cardRequest.getCardType()) {
            case POKEMON -> createPokemonCard(cardRequest);
            case TRAINER -> createTrainerCard(cardRequest);
            case ENERGY -> createEnergyCard(cardRequest);
            default -> throw new IllegalArgumentException("Unknown card type: " + cardRequest.getCardType());
        };
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
        pokemonCard.setPokemonCardTypes(cardRequest.getPokemonCardTypes());
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
        energyCard.setEnergyCardTypes(cardRequest.getEnergyCardTypes());
    }

    private void updateTrainerCard(TrainerCard trainerCard, CardRequest cardRequest) {
        updateCommonFields(trainerCard, cardRequest);
        trainerCard.setTrainerCardTypes(cardRequest.getTrainerCardTypes());
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
        card.setCardNumber(cardRequest.getCardNumber());
    }
}
