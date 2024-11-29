package com.competition.competition.service;

import com.competition.competition.dto.CardRequestDTO;
import com.competition.competition.dto.CardResponseDTO;
import com.competition.competition.dto.mapper.CardRequestMapper;
import com.competition.competition.dto.mapper.CardResponseMapper;
import com.competition.competition.entity.Card;
import com.competition.competition.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardRequestMapper cardRequestMapper;

    public Card createCard(CardRequestDTO cardRequestDTO) {
        Card card = cardRequestMapper.requestToCard(cardRequestDTO);
        return cardRepository.save(card);
    }

    public List<Card> createCards(List<CardRequestDTO> cardRequestDTOList) {
        List<Card> cards = new ArrayList<>();

        for (CardRequestDTO cardRequestDTO : cardRequestDTOList) {
            Card card = cardRequestMapper.requestToCard(cardRequestDTO);
            cards.add(card);
        }

        return cardRepository.saveAll(cards);
    }

    public List<CardResponseDTO> getAllCards() {
        return cardRepository.findAll().stream().map(CardResponseMapper::toCardResponse).collect(Collectors.toList());
    }

    public CardResponseDTO getCardById(Long id) {
        Card card = cardRepository.findById(id).orElse(null);
        if (card == null) {
            return null;
        }
        return CardResponseMapper.toCardResponse(card);
    }

    public boolean deleteCard(Long id) {
        Card card = cardRepository.findById(id).orElse(null);
        if (card == null) {
            return false;
        }
        cardRepository.delete(card);
        return true;
    }
}
