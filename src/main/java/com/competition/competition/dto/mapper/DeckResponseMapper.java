package com.competition.competition.dto.mapper;

import com.competition.competition.dto.DeckCardResponseDTO;
import com.competition.competition.dto.DeckResponseDTO;
import com.competition.competition.entity.Deck;
import com.competition.competition.entity.DeckCard;

import java.util.ArrayList;
import java.util.List;

public class DeckResponseMapper {
    public static DeckResponseDTO map(Deck deck) {
        DeckResponseDTO deckResponseDTO = new DeckResponseDTO();
        deckResponseDTO.setId(deck.getId());
        deckResponseDTO.setName(deck.getName());
        deckResponseDTO.setAuthor(deck.getAuthor());
        deckResponseDTO.setArchetypeId(deck.getArchetype().getId());
        deckResponseDTO.setCards(mapCards(deck.getCards()));
        deckResponseDTO.setTotalPrice(deck.getTotalPrice());

        return deckResponseDTO;
    }

    private static List<DeckCardResponseDTO> mapCards(List<DeckCard> deckCards) {
        List<DeckCardResponseDTO> deckCardResponseDTOS = new ArrayList<>();
        for (DeckCard deckCard : deckCards) {
            DeckCardResponseDTO deckCardResponseDTO = new DeckCardResponseDTO();
            deckCardResponseDTO.setCardId(deckCard.getCardId());
            deckCardResponseDTO.setCardQuantity(deckCard.getQuantity());
            deckCardResponseDTOS.add(deckCardResponseDTO);
        }

        return deckCardResponseDTOS;
    }
}
