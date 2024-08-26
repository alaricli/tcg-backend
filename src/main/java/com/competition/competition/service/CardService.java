package com.competition.competition.service;

import com.competition.competition.dto.CardRequest;
import com.competition.competition.entity.Card;
import com.competition.competition.entity.Expansion;
import com.competition.competition.repository.CardRepository;
import com.competition.competition.repository.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ExpansionRepository expansionRepository;

    // GET
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card getCardById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    // POST
    public Card createCard(CardRequest cardRequest) {
        Card card = makeCard(cardRequest);
        return cardRepository.save(card);
    }

    // PUT
    public Card updateCard(Card Card) {
        return cardRepository.save(Card);
    }

    // DELETE
    public ResponseEntity<Void> deleteCardById(Long id) {
        cardRepository.deleteById(id);
        return null;
    }

    // HELPERS
    private Card makeCard(CardRequest cardRequest) {
        Card newCard = new Card();
        updateEntityFromRequest(newCard, cardRequest);
        return newCard;
    }

    private void updateEntityFromRequest(Card card, CardRequest cardRequest) {
        Expansion expansion = expansionRepository.findById(cardRequest.getExpansionId()).orElseThrow(() -> new RuntimeException("Expansion not found"));

        card.setHp(cardRequest.getHp());
        card.setRetreatCost(cardRequest.getRetreatCost());
        card.setName(cardRequest.getName());
        card.setArtist(cardRequest.getArtist());
        card.setPicUrl(cardRequest.getPicUrl());
        card.setAbility(cardRequest.getAbility());
        card.setPrice(cardRequest.getPrice());
        card.setCardType(cardRequest.getCardType());
        card.setPokemonCardType(cardRequest.getPokemonCardType());
        card.setTrainerCardType(cardRequest.getTrainerCardType());
        card.setEnergyCardType(cardRequest.getEnergyCardType());
        card.setEnergyCardType(cardRequest.getEnergyCardType());
        card.setAttackEnergyType(cardRequest.getAttackEnergyType());
        card.setWeakness(cardRequest.getWeakness());
        card.setResistance(cardRequest.getResistance());
        card.setRarity(cardRequest.getRarity());
        card.setFormat(cardRequest.getFormat());
        card.setExpansion(expansion);
    }
}
