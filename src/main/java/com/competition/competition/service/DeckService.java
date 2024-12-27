package com.competition.competition.service;

import com.competition.competition.dto.DeckRequestDTO;
import com.competition.competition.dto.DeckResponseDTO;
import com.competition.competition.dto.mapper.DeckResponseMapper;
import com.competition.competition.entity.Archetype;
import com.competition.competition.entity.Deck;
import com.competition.competition.entity.DeckCard;
import com.competition.competition.repository.ArchetypeRepository;
import com.competition.competition.repository.DeckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeckService {
    @Autowired
    private DeckRepository deckRepository;
    @Autowired
    private ArchetypeRepository archetypeRepository;

    public List<Deck> createDecks(List<DeckRequestDTO> deckRequests) {
        List<Deck> decks = deckRequests.stream().map(deckRequest -> {
            Archetype archetype = archetypeRepository.findById(deckRequest.getArchetypeId()).orElseThrow(() -> new RuntimeException("Archetype not found " + deckRequest.getArchetypeId()));


            Deck deck = new Deck();
            deck.setArchetype(archetype);
            deck.setName(deckRequest.getName());
            deck.setAuthor(deckRequest.getAuthor());
            deck.setTotalPrice(deckRequest.getTotalPrice());

            List<DeckCard> deckCards = deckRequest.getCards().stream().map(cardRequest -> {
                DeckCard deckCard = new DeckCard();
                deckCard.setCardId(cardRequest.getCardId());
                deckCard.setQuantity(cardRequest.getQuantity());
                deckCard.setDeck(deck);
                return deckCard;
            }).toList();

            deck.setCards(deckCards);
            return deck;
        }).collect(Collectors.toList());

        return deckRepository.saveAll(decks);
    }

    public List<DeckResponseDTO> getDecks() {
        List<Deck> decks = deckRepository.findAll();
        List<DeckResponseDTO> deckResponses = new ArrayList<>();
        for (Deck deck : decks) {
            DeckResponseDTO deckResponse = DeckResponseMapper.map(deck);
            deckResponses.add(deckResponse);
        }

        return deckResponses;
    }

    public DeckResponseDTO getDeck(Long id) {
        Deck deck = deckRepository.findById(id).orElse(null);
        assert deck != null;
        return DeckResponseMapper.map(deck);
    }

    public String deleteDeck(Long id) {
        deckRepository.deleteById(id);
        return "Deck deleted";
    }
}
