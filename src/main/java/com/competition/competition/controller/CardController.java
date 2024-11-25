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
import java.util.Map;

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

//    @PatchMapping("/patch/{id}")
//    public ResponseEntity<CardResponse> patchCard(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
//        CardResponse updatedCard = cardService.updateCardById(id, updates);
//        if (updatedCard != null) {
//            return ResponseEntity.ok(updatedCard);
//        }
//        return ResponseEntity.notFound().build();
//    }

    @PutMapping("/put/{id}")
    public ResponseEntity<CardResponse> putCard(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
        CardResponse updatedCard = cardService.updateCardById(id, updates);
        if (updatedCard != null) {
            return ResponseEntity.ok(updatedCard);

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
