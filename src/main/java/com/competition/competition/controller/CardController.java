package com.competition.competition.controller;

import com.competition.competition.dto.CardRequestDTO;
import com.competition.competition.dto.CardResponseDTO;
import com.competition.competition.dto.CardResponseSimplifiedDTO;
import com.competition.competition.entity.Card;
import com.competition.competition.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/getAllOld")
    public ResponseEntity<List<CardResponseDTO>> getCards() {
        List<CardResponseDTO> cardResponseDTOS = cardService.getAllCards();
        return ResponseEntity.ok(cardResponseDTOS);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CardResponseDTO> getCardById(@PathVariable("id") String id) {
        CardResponseDTO cardResponseDTO = cardService.getCardById(id);
        if (cardResponseDTO != null) {
            return ResponseEntity.ok(cardResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/cards")
    public ResponseEntity<List<CardResponseSimplifiedDTO>> getCardSummaries(@RequestParam(required = false) Optional<String> expansionId,
                                                                            @RequestParam(required = false) Optional<String> packId,
                                                                            @RequestParam(required = false) Optional<String> searchText,
                                                                            @RequestParam(required = false) Optional<String> rarity,
                                                                            @RequestParam(required = false) Optional<Boolean> hasAbility,
                                                                            @RequestParam(required = false) Optional<Boolean> hasRuleBox,
                                                                            @RequestParam(required = false) Optional<String> energyType,
                                                                            @RequestParam(required = false) Optional<String> weakness,
                                                                            @RequestParam(required = false) Optional<Integer> retreatCost,
                                                                            @RequestParam(required = false) Optional<String> superType,
                                                                            @RequestParam(required = false) Optional<String> subType,
                                                                            @RequestParam(required = false) Optional<String> sortType,
                                                                            @RequestParam(required = false) Optional<String> sortDirection
    ) {
        List<CardResponseSimplifiedDTO> cards = cardService.getProcessedCards(
                expansionId, packId, searchText, rarity, hasAbility, hasRuleBox, energyType, weakness, retreatCost, superType, subType, sortType, sortDirection);
        return ResponseEntity.ok(cards);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCardById(@PathVariable("id") String id) {
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
