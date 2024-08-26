package com.competition.competition.controller;

import com.competition.competition.dto.CardRequest;
import com.competition.competition.entity.Card;
import com.competition.competition.service.CardService;
import com.competition.competition.util.CSVProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PostMapping("/importCards")
    public ResponseEntity<String> importCards(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload a CSV file.");
        }

        try {
            List<CardRequest> cards = CSVProcessor.csvToCards(file);
            cardService.createCards(cards);
            return ResponseEntity.ok("Cards imported successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to import cards: " + e.getMessage());
        }
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
