package com.competition.competition.controller;

import com.competition.competition.dto.CardRequest;
import com.competition.competition.entity.Card;
import com.competition.competition.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/{id}")
    public Card getCardById(@PathVariable Long id) {
        return cardService.getCardById(id);
    }

    // take in a JSON body with card details
    @PostMapping("/add")
    public Card addCard(@RequestBody CardRequest cardRequest) {
        Card card = new Card();
        card.setName(cardRequest.getName());
        card.setSet(cardRequest.getSet());
        return cardService.addCard(card);
    }

    @PutMapping
    public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody Card cardDetails) {
        Card card = cardService.getCardById(id);
        if (card != null) {
            card.setName(cardDetails.getName());
            card.setSet(cardDetails.getSet());
            Card updatedCard = cardService.addCard(card);
            return ResponseEntity.ok(updatedCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        cardService.deleteCardById(id);
        return ResponseEntity.noContent().build();
    }
}
