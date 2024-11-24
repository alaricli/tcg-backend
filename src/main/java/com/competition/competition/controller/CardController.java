package com.competition.competition.controller;

import com.competition.competition.dto.cardrequest.CardRequest;
import com.competition.competition.dto.cardresponse.CardResponse;
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

    @GetMapping("/get")
    public ResponseEntity<List<CardResponse>> getCards() {
        List<CardResponse> cardResponses = cardService.getAllCards();
        return ResponseEntity.ok(cardResponses);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CardResponse> getCardById(@PathVariable("id") Long id) {
        CardResponse cardResponse = cardService.getCardById(id);
        if (cardResponse != null) {
            return ResponseEntity.ok(cardResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCardById(@PathVariable("id") Long id) {
        try {
            boolean deleted = cardService.deleteCard(id);
            if (deleted) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
