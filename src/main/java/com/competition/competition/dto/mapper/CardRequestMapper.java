package com.competition.competition.dto.mapper;

import com.competition.competition.dto.CardRequestDTO;
import com.competition.competition.entity.Card;
import com.competition.competition.entity.Expansion;
import com.competition.competition.repository.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardRequestMapper {
    @Autowired
    private ExpansionRepository expansionRepository;

    public Card requestToCard(CardRequestDTO cardRequest) {
        Card card = new Card();
        card.setName(cardRequest.getName());
        card.setHp(cardRequest.getHp());
        card.setAbility(cardRequest.getAbility());
        card.setArtist(cardRequest.getArtist());
        card.setCardNumber(cardRequest.getCardNumber());
        card.setSuperType(cardRequest.getSuperType());
        card.setSubTypes(cardRequest.getSubTypes());
        card.setCardImages(cardRequest.getCardImages());
        card.setRarity(cardRequest.getRarity());
        card.setRegulationMark(cardRequest.getRegulationMark());
        card.setPrice(cardRequest.getPrice());
        card.setMarketPrice(cardRequest.getMarketPrice());
        card.setRules(cardRequest.getRules());
        card.setRetreatCost(cardRequest.getRetreatCost());
        card.setIdentifier(cardRequest.getIdentifier());
        card.setLegalities(cardRequest.getLegalities());
        card.setEnergyTypes(cardRequest.getEnergyTypes());
        card.setTrainerCardText(cardRequest.getTrainerCardText());
        card.setNationalPokedexNumber(cardRequest.getNationalPokedexNumber());
        card.setAttacks(cardRequest.getAttacks());
        card.setAttackEnergyTypes(cardRequest.getAttackEnergyTypes());
        card.setWeakness(cardRequest.getWeakness());
        card.setResistance(cardRequest.getResistance());
        card.setHasRuleBox(cardRequest.isHasRuleBox());
        card.setHasAbility(cardRequest.isHasAbility());
        if (cardRequest.getExpansionId() != null) {
            Expansion expansion = expansionRepository.findById(cardRequest.getExpansionId()).orElse(null);
            card.setExpansion(expansion);
        }

        return card;
    }
}
