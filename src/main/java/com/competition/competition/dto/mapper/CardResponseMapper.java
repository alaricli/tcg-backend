package com.competition.competition.dto.mapper;

import com.competition.competition.dto.CardResponseDTO;
import com.competition.competition.entity.Card;

public class CardResponseMapper {
    public static CardResponseDTO toCardResponse(Card card) {
        CardResponseDTO cardResponseDTO = new CardResponseDTO();
        cardResponseDTO.setId(card.getId());
        cardResponseDTO.setName(card.getName());
        cardResponseDTO.setHp(card.getHp());
        cardResponseDTO.setArtist(card.getArtist());
        cardResponseDTO.setRegulationMark(card.getRegulationMark());
        cardResponseDTO.setPrice(card.getPrice());
        cardResponseDTO.setMarketPrice(card.getMarketPrice());
        cardResponseDTO.setRules(card.getRules());
        cardResponseDTO.setExpansionId(card.getExpansion().getId());
        cardResponseDTO.setCardNumber(card.getCardNumber());
        cardResponseDTO.setRarity(card.getRarity());
        cardResponseDTO.setCardImages(card.getCardImages());
        cardResponseDTO.setLegalities(card.getLegalities());
        cardResponseDTO.setPullRates(card.getPullRates());
        cardResponseDTO.setEnergyTypes(card.getEnergyTypes());
        cardResponseDTO.setAttacks(card.getAttacks());
        cardResponseDTO.setAttackEnergyTypes(card.getAttackEnergyTypes());
        cardResponseDTO.setWeakness(card.getWeakness());
        cardResponseDTO.setResistance(card.getResistance());
        cardResponseDTO.setNationalDexNumber(card.getNationalDexNumber());
        cardResponseDTO.setRetreatCost(card.getRetreatCost());
        cardResponseDTO.setHasRuleBox(card.getHasRuleBox());
        cardResponseDTO.setHasAbility(card.getHasAbility());
        cardResponseDTO.setAbility(card.getAbility());
        cardResponseDTO.setTrainerCardText(card.getTrainerCardText());
        cardResponseDTO.setSuperType(card.getSuperType());
        cardResponseDTO.setSubTypes(card.getSubTypes());
        cardResponseDTO.setDustCost(card.getDustCost());
        cardResponseDTO.setFoundInPacks(card.getFoundInPacks());
        cardResponseDTO.setEvolvesFrom(card.getEvolvesFrom());
        cardResponseDTO.setEvolvesTo(card.getEvolvesTo());
        cardResponseDTO.setMainType(card.getMainType());
        cardResponseDTO.setExpansionLogo(card.getExpansion().getExpansionImages().getLogo());
        cardResponseDTO.setExpansionSymbol(card.getExpansion().getExpansionImages().getSymbol());
        cardResponseDTO.setExpansionName(card.getExpansion().getName());
        return cardResponseDTO;
    }
}
