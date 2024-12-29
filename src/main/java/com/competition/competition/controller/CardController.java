package com.competition.competition.controller;

import com.competition.competition.dto.CardRequestDTO;
import com.competition.competition.dto.CardResponseDTO;
import com.competition.competition.dto.CardResponseSimplifiedDTO;
import com.competition.competition.entity.Card;
import com.competition.competition.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CardController {
    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("/add/cards")
    public ResponseEntity<List<Card>> addCards(@RequestBody List<CardRequestDTO> cardRequestDTOList) {
        List<Card> createdCards = cardService.createCards(cardRequestDTOList);
        return ResponseEntity.ok(createdCards);
    }

    @GetMapping("/get/card/{id}")
    public ResponseEntity<CardResponseDTO> getCardById(@PathVariable("id") String id) {
        CardResponseDTO cardResponseDTO = cardService.getCardById(id);

        if (cardResponseDTO != null) {
            return ResponseEntity.ok(cardResponseDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/get/all/cards/simplified")
    public ResponseEntity<List<CardResponseSimplifiedDTO>> getAllCardsSimplified() {
        return ResponseEntity.ok(cardService.getAllSimplifiedCards());
    }

    @GetMapping("/get/all/cards/full")
    public ResponseEntity<List<CardResponseDTO>> getAllCardsFull() {
        return ResponseEntity.ok(cardService.getAllCards());
    }

    @GetMapping("/get/cards")
    public ResponseEntity<List<CardResponseSimplifiedDTO>> getCardSummaries(@RequestParam(required = false) String expansionId,
                                                                            @RequestParam(required = false) String packId,
                                                                            @RequestParam(required = false) String searchText,
                                                                            @RequestParam(required = false) String rarity,
                                                                            @RequestParam(required = false) Boolean hasAbility,
                                                                            @RequestParam(required = false) Boolean hasRuleBox,
                                                                            @RequestParam(required = false) String energyType,
                                                                            @RequestParam(required = false) String weakness,
                                                                            @RequestParam(required = false) Integer retreatCost,
                                                                            @RequestParam(required = false) String superType,
                                                                            @RequestParam(required = false) String subType,
                                                                            @RequestParam(required = false) String sortBy,
                                                                            @RequestParam(required = false) String sortDirection,
                                                                            @RequestParam(defaultValue = "1") Integer page,
                                                                            @RequestParam(defaultValue = "40") Integer pageSize
    ) {
        List<CardResponseSimplifiedDTO> cards = cardService.queryCards(
                expansionId, packId, searchText, rarity, hasAbility, hasRuleBox, energyType, weakness, retreatCost, superType, subType, sortBy, sortDirection, page, pageSize);
        return ResponseEntity.ok(cards);
    }

    @DeleteMapping("/delete/card/{id}")
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
