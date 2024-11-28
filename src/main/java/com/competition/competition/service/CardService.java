package com.competition.competition.service;

import com.competition.competition.dto.CardRequestDTO;
import com.competition.competition.dto.CardResponseDTO;
import com.competition.competition.dto.mapper.CardRequestMapper;
import com.competition.competition.dto.mapper.CardResponseMapper;
import com.competition.competition.entity.Expansion;
import com.competition.competition.entity.Card;
import com.competition.competition.repository.CardRepository;
import com.competition.competition.repository.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private ExpansionRepository expansionRepository;
    @Autowired
    private CardRequestMapper cardRequestMapper;

//    public Card createCard(CardRequestDTO cardRequestDTO) {
//        Card card = cardRequestMapper.mapToCard(cardRequestDTO);
//        return cardRepository.save(card);
//    }

//    public List<CardResponseDTO> getAllCards() {
//        return cardRepository.findAll().stream().map(CardResponseMapper::toCardResponse).collect(Collectors.toList());
//    }
//
//    public CardResponseDTO getCardById(Long id) {
//        Card card = cardRepository.findById(id).orElse(null);
//        if (card == null) {
//            return null;
//        }
//        return CardResponseMapper.toCardResponse(card);
//    }
//
//    public CardResponseDTO updateCardById(Long id, Map<String, Object> updates) {
//        Card card = cardRepository.findById(id).orElse(null);
//        if (card == null) {
//            return null;
//        }
//
//        updates.forEach((key, value) -> {
//            if (key.equals("id") || key.equals("price")) {
//                return;
//            }
//
//            Field field = ReflectionUtils.findField(Card.class, key);
//            if (field != null) {
//                field.setAccessible(true);
//
//                try {
//                    if (key.equals("expansionId")) {
//                        // Handle specific fields like `expansionId`
//                        Long expansionId = Long.valueOf(value.toString());
//                        Expansion expansion = expansionRepository.findById(expansionId)
//                                .orElseThrow(() -> new RuntimeException("Expansion not found"));
//                        card.setExpansion(expansion);
//
//                    } else if (field.getType().isEnum()) {
//                        // Generalized handling for all enums
//                        Object enumValue = Enum.valueOf((Class<Enum>) field.getType(), value.toString().toUpperCase());
//                        ReflectionUtils.setField(field, card, enumValue);
//
//                    } else {
//                        // Handle all other fields
//                        ReflectionUtils.setField(field, card, value);
//                    }
//                } catch (IllegalArgumentException e) {
//                    throw new IllegalArgumentException("Invalid value for field: " + key, e);
//                }
//            }
//        });
//
//
//        Card updatedCard = cardRepository.save(card);
//
//        return CardResponseMapper.toCardResponse(updatedCard);
//    }
//
//    public boolean deleteCard(Long id) {
//        Card card = cardRepository.findById(id).orElse(null);
//        if (card == null) {
//            return false;
//        }
//        cardRepository.delete(card);
//        return true;
//    }
}
