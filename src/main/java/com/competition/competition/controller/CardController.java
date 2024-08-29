package com.competition.competition.controller;

import com.competition.competition.dto.CardRequest;
import com.competition.competition.dto.CardResponse;
import com.competition.competition.entity.card.Card;
import com.competition.competition.service.CardService;
import com.competition.competition.util.CSVProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping("/import")
    public ResponseEntity<String> importCards(@RequestParam("file") MultipartFile file) {
        List<CardRequest> cardRequests = CSVProcessor.csvToCards(file);
        for (CardRequest cardRequest : cardRequests) {
            cardService.createCard(cardRequest);
        }
        return ResponseEntity.ok("Cards imported successfully");
    }

    @GetMapping("/getCardTest/{id}")
    public ResponseEntity<Card> getCardTest(@PathVariable("id") Long id) {
        Card card = cardService.getCardById(id);
        return ResponseEntity.ok(card);
    }

    @GetMapping("/getCard/{id}")
    public ResponseEntity<CardResponse> getCardById(@PathVariable Long id) {
        Card card = cardService.getCardById(id);

        if (card == null) {
            return ResponseEntity.notFound().build();
        }
        CardResponse cardResponse = cardService.getCardResponse(card);
        return ResponseEntity.ok(cardResponse);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Card>> getAllCards() {
        return ResponseEntity.ok(cardService.getAllCards());
    }
}
