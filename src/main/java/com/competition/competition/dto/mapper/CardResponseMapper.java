package com.competition.competition.dto.mapper;

import com.competition.competition.dto.cardresponse.CardResponse;
import com.competition.competition.entity.card.Card;
import com.competition.competition.entity.card.EnergyCard;
import com.competition.competition.entity.card.PokemonCard;
import com.competition.competition.entity.card.TrainerCard;

public class CardResponseMapper {
    public static CardResponse toCardResponse(Card card) {
        CardResponse cardResponse = new CardResponse();
        cardResponse.setId(card.getId());
        cardResponse.setName(card.getName());
        cardResponse.setArtist(card.getArtist());
        cardResponse.setPicUrl(card.getPicUrl());
        cardResponse.setPrice(card.getPrice());
        cardResponse.setRarity(card.getRarity());
        cardResponse.setFormat(card.getFormat());
        cardResponse.setExpansionName(card.getExpansion().getName());

        if (card instanceof PokemonCard pokemonCard) {
            cardResponse.setAbility(pokemonCard.getAbility());
            cardResponse.setHp(pokemonCard.getHp());
            cardResponse.setRetreatCost(pokemonCard.getRetreatCost());
            cardResponse.setPokemonCardType(pokemonCard.getPokemonCardType());
            cardResponse.setEnergyType(pokemonCard.getEnergyType());
            cardResponse.setAttackEnergyType(pokemonCard.getAttackEnergyType());
            cardResponse.setWeakness(pokemonCard.getWeakness());
            cardResponse.setResistance(pokemonCard.getResistance());
        } else if (card instanceof TrainerCard trainerCard) {
            cardResponse.setTrainerCardType(trainerCard.getTrainerCardType());
        } else if (card instanceof EnergyCard energyCard) {
            cardResponse.setEnergyType(energyCard.getEnergyType());
            cardResponse.setEnergyCardType(energyCard.getEnergyCardType());
        }

        return cardResponse;
    }
}
