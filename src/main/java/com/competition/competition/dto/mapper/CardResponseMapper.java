package com.competition.competition.dto.mapper;

import com.competition.competition.dto.CardResponseDTO;
import com.competition.competition.entity.Card;

public class CardResponseMapper {
    public static CardResponseDTO toCardResponse(Card card) {
        CardResponseDTO cardResponseDTO = new CardResponseDTO();
        cardResponseDTO.setName(card.getName());
        cardResponseDTO.setHp(card.getHp());
        cardResponseDTO.setArtist(card.getArtist());
        cardResponseDTO.setRegulationMark(card.getRegulationMark());
        cardResponseDTO.setPrice(card.getPrice());
        cardResponseDTO.setMarketPrice(card.getMarketPrice());
        cardResponseDTO.setRules(card.getRules());
        cardResponseDTO.setExpansionId(card.getExpansion().getId());
        cardResponseDTO.setIdentifier(card.getIdentifier());
        cardResponseDTO.setCardNumber(card.getCardNumber());
        cardResponseDTO.setRarity(card.getRarity());
        cardResponseDTO.setCardType(card.getCardType());
        cardResponseDTO.setCardImages(card.getCardImages());
        cardResponseDTO.setLegalities(card.getLegalities());
        cardResponseDTO.setEnergyTypes(card.getEnergyTypes());
        cardResponseDTO.setPokemonCardTypes(card.getPokemonCardTypes());
        cardResponseDTO.setAttackEnergyTypes(card.getAttackEnergyTypes());
        cardResponseDTO.setWeakness(card.getWeakness());
        cardResponseDTO.setResistance(card.getResistance());
        cardResponseDTO.setNationalPokedexNumber(card.getNationalPokedexNumber());
        cardResponseDTO.setRetreatCost(card.getRetreatCost());
        cardResponseDTO.setHasRuleBox(card.isHasRuleBox());
        cardResponseDTO.setHasAbility(card.isHasAbility());
        cardResponseDTO.setAbility(card.getAbility());
        cardResponseDTO.setTrainerCardTypes(card.getTrainerCardTypes());
        cardResponseDTO.setTrainerCardText(card.getTrainerCardText());
        cardResponseDTO.setEnergyCardTypes(card.getEnergyCardTypes());

        return cardResponseDTO;
    }
}
