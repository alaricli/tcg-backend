package com.competition.competition.service;

import com.competition.competition.dto.cardrequest.CardRequest;
import com.competition.competition.dto.cardrequest.EnergyCardRequest;
import com.competition.competition.dto.cardrequest.PokemonCardRequest;
import com.competition.competition.dto.cardrequest.TrainerCardRequest;
import com.competition.competition.entity.Expansion;
import com.competition.competition.entity.card.Card;
import com.competition.competition.entity.card.EnergyCard;
import com.competition.competition.entity.card.PokemonCard;
import com.competition.competition.entity.card.TrainerCard;
import com.competition.competition.enums.CardType;
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
        Card card = null;
        CardType cardType = cardRequest.getCardType();

        card = switch (cardType) {
            case POKEMON -> createPokemonCard((PokemonCardRequest) cardRequest);
            case TRAINER -> createTrainerCard((TrainerCardRequest) cardRequest);
            case ENERGY -> createEnergyCard((EnergyCardRequest) cardRequest);
            default -> throw new IllegalArgumentException("Unknown card type: " + cardType);
        };

        return cardRepository.save(card);
    }

    private Card createPokemonCard(PokemonCardRequest pokemonCardRequest) {
        PokemonCard pokemonCard = new PokemonCard();
        updatePokemonFields(pokemonCard, pokemonCardRequest);
        return pokemonCard;
    }

    private Card createTrainerCard(TrainerCardRequest trainerCardRequest) {
        TrainerCard trainerCard = new TrainerCard();
        updateTrainerCard(trainerCard, trainerCardRequest);
        return trainerCard;
    }

    private Card createEnergyCard(EnergyCardRequest energyCardRequest) {
        EnergyCard energyCard = new EnergyCard();
        updateEnergyCard(energyCard, energyCardRequest);
        return energyCard;
    }

    private void updatePokemonFields(PokemonCard pokemonCard, PokemonCardRequest pokemonCardRequest) {
        updateCommonFields(pokemonCard, pokemonCardRequest);
        pokemonCard.setAbility(pokemonCardRequest.getAbility());
        pokemonCard.setPokemonCardType(pokemonCardRequest.getPokemonCardType());
        pokemonCard.setHp(pokemonCardRequest.getHp());
        pokemonCard.setRetreatCost(pokemonCardRequest.getRetreatCost());
        pokemonCard.setWeakness(pokemonCardRequest.getWeakness());
        pokemonCard.setResistance(pokemonCardRequest.getResistance());
        pokemonCard.setEnergyType(pokemonCardRequest.getEnergyType());
        pokemonCard.setAttackEnergyType(pokemonCardRequest.getAttackEnergyType());
    }

    private void updateEnergyCard(EnergyCard energyCard, EnergyCardRequest energyCardRequest) {
        updateCommonFields(energyCard, energyCardRequest);
        energyCard.setEnergyType(energyCardRequest.getEnergyType());
        energyCard.setEnergyCardType(energyCardRequest.getEnergyCardType());
    }

    private void updateTrainerCard(TrainerCard trainerCard, TrainerCardRequest trainerCardRequest) {
        updateCommonFields(trainerCard, trainerCardRequest);
        trainerCard.setTrainerCardType(trainerCardRequest.getTrainerCardType());
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
