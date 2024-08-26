package com.competition.competition.controller;

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

    @GetMapping("/getAll")
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/getCard")
    public Card getCardById(@RequestParam Long id) {
        return cardService.getCardById(id);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        return cardService.deleteCardById(id);
    }
}
