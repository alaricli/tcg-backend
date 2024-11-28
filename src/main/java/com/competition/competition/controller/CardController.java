package com.competition.competition.controller;

import com.competition.competition.dto.CardRequestDTO;
import com.competition.competition.dto.CardResponseDTO;
import com.competition.competition.entity.Card;
import com.competition.competition.service.CardService;
import com.competition.competition.util.CSVProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

//    @PostMapping("/add")
//    public ResponseEntity<?> addCard(@RequestBody CardRequestDTO cardRequestDTO) {
//        try {
//            Card createdCard = cardService.createCard(cardRequestDTO);
//            return ResponseEntity.status(HttpStatus.CREATED).body(createdCard);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the card.");
//        }
//    }
//
//    @PostMapping("/import")
//    public ResponseEntity<String> importCards(@RequestParam("file") MultipartFile file) {
//        List<CardRequestDTO> cardRequestDTOS = CSVProcessor.csvToCards(file);
//        for (CardRequestDTO cardRequestDTO : cardRequestDTOS) {
//            cardService.createCard(cardRequestDTO);
//        }
//        return ResponseEntity.ok("Cards imported successfully");
//    }
//
//    @GetMapping("/get")
//    public ResponseEntity<List<CardResponseDTO>> getCards() {
//        List<CardResponseDTO> cardResponsDTOS = cardService.getAllCards();
//        return ResponseEntity.ok(cardResponsDTOS);
//    }
//
//    @GetMapping("/get/{id}")
//    public ResponseEntity<CardResponseDTO> getCardById(@PathVariable("id") Long id) {
//        CardResponseDTO cardResponseDTO = cardService.getCardById(id);
//        if (cardResponseDTO != null) {
//            return ResponseEntity.ok(cardResponseDTO);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PutMapping("/put/{id}")
//    public ResponseEntity<CardResponseDTO> putCard(@PathVariable("id") Long id, @RequestBody Map<String, Object> updates) {
//        CardResponseDTO updatedCard = cardService.updateCardById(id, updates);
//        if (updatedCard != null) {
//            return ResponseEntity.ok(updatedCard);
//
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> deleteCardById(@PathVariable("id") Long id) {
//        try {
//            boolean deleted = cardService.deleteCard(id);
//            if (deleted) {
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.noContent().build();
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }
}
