package com.competition.competition.controller;

import com.competition.competition.dto.CardRequestDTO;
import com.competition.competition.dto.CardResponseDTO;
import com.competition.competition.entity.Card;
import com.competition.competition.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/add")
    public ResponseEntity<Card> addCard(@RequestBody CardRequestDTO cardRequestDTO) {
        Card createdCard = cardService.createCard(cardRequestDTO);
        return ResponseEntity.ok(createdCard);
    }

    @PostMapping("/add/bulk")
    public ResponseEntity<List<Card>> addCards(@RequestBody List<CardRequestDTO> cardRequestDTOList) {
        List<Card> createdCards = cardService.createCards(cardRequestDTOList);
        return ResponseEntity.ok(createdCards);
    }

    @GetMapping("/get")
    public ResponseEntity<List<CardResponseDTO>> getCards() {
        List<CardResponseDTO> cardResponseDTOS = cardService.getAllCards();
        return ResponseEntity.ok(cardResponseDTOS);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CardResponseDTO> getCardById(@PathVariable("id") Long id) {
        CardResponseDTO cardResponseDTO = cardService.getCardById(id);
        if (cardResponseDTO != null) {
            return ResponseEntity.ok(cardResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCardById(@PathVariable("id") Long id) {
        try {
            boolean deleted = cardService.deleteCard(id);
            if (!deleted) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
