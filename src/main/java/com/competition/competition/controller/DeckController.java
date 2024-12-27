package com.competition.competition.controller;

import com.competition.competition.dto.DeckRequestDTO;
import com.competition.competition.dto.DeckResponseDTO;
import com.competition.competition.entity.Deck;
import com.competition.competition.service.DeckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DeckController {
    private final DeckService deckService;

    public DeckController(DeckService deckService) {
        this.deckService = deckService;
    }

    @PostMapping("/add/decks")
    public ResponseEntity<List<Deck>> addDecks(@RequestBody List<DeckRequestDTO> deckRequests) {
        List<Deck> createdDecks = deckService.createDecks(deckRequests);
        return new ResponseEntity<>(createdDecks, HttpStatus.OK);
    }

    @GetMapping("/get/decks")
    public ResponseEntity<List<DeckResponseDTO>> getDecks() {
        List<DeckResponseDTO> decks = deckService.getDecks();
        return new ResponseEntity<>(decks, HttpStatus.OK);
    }

    @GetMapping("/get/deck/{id}")
    public ResponseEntity<DeckResponseDTO> getDeckById(@PathVariable Long id) {
        DeckResponseDTO deck = deckService.getDeck(id);
        return new ResponseEntity<>(deck, HttpStatus.OK);
    }

    @DeleteMapping("/delete/deck/{id}")
    public ResponseEntity<?> deleteDeckById(@PathVariable Long id) {
        return new ResponseEntity<>(deckService.deleteDeck(id), HttpStatus.OK);
    }
}
