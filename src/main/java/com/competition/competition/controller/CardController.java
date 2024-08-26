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

    @PostMapping("/addCard")
    public ResponseEntity<Card> addCard(@RequestBody CardRequest cardRequest) {
        Card newCard = cardService.createCard(cardRequest);
        return ResponseEntity.ok(newCard);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Card>> getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @GetMapping("/getCard/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @PutMapping("/updateCard/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody CardRequest cardRequest) {
        return ResponseEntity.ok(cardService.updateCard(id, cardRequest));
    }

    @DeleteMapping("/deleteCard/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        return cardService.deleteCardById(id);
    }
}
