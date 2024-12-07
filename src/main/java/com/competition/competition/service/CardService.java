package com.competition.competition.service;

import com.competition.competition.dto.CardRequestDTO;
import com.competition.competition.dto.CardResponseDTO;
import com.competition.competition.dto.CardResponseSimplifiedDTO;
import com.competition.competition.dto.mapper.CardRequestMapper;
import com.competition.competition.dto.mapper.CardResponseMapper;
import com.competition.competition.entity.Card;
import com.competition.competition.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardRequestMapper cardRequestMapper;

    public Card createCard(CardRequestDTO cardRequestDTO) {
        Card card = cardRequestMapper.requestToCard(cardRequestDTO);
        return cardRepository.save(card);
    }

    public List<Card> createCards(List<CardRequestDTO> cardRequestDTOList) {
        List<Card> cards = new ArrayList<>();

        for (CardRequestDTO cardRequestDTO : cardRequestDTOList) {
            Card card = cardRequestMapper.requestToCard(cardRequestDTO);
            cards.add(card);
        }

        return cardRepository.saveAll(cards);
    }

    public List<CardResponseDTO> getAllCards() {
        return cardRepository.findAll().stream().map(CardResponseMapper::toCardResponse).collect(Collectors.toList());
    }

    public List<CardResponseSimplifiedDTO> getProcessedCards(Optional<String> expansionId,
                                                             Optional<String> packId,
                                                             Optional<String> searchText,
                                                             Optional<String> rarity,
                                                             Optional<Boolean> hasAbility,
                                                             Optional<Boolean> hasRuleBox,
                                                             Optional<String> energyType,
                                                             Optional<String> weakness,
                                                             Optional<Integer> retreatCost,
                                                             Optional<String> superType,
                                                             Optional<String> subType,
                                                             Optional<String> sortType,
                                                             Optional<String> sortDirection
    ) {
        Sort.Direction direction = sortDirection.map(Sort.Direction::valueOf).orElse(Sort.Direction.ASC);
        String sortBy = sortType.orElse("id");
        Sort sort = Sort.by(direction, sortBy);

        return cardRepository.findSummarizedCardsFiltered(
                expansionId.orElse(null),
                searchText.orElse(null),
                rarity.orElse(null),
                packId.orElse(null),
                hasAbility.orElse(null),
                hasRuleBox.orElse(null),
                energyType.orElse(null),
                weakness.orElse(null),
                retreatCost.orElse(null),
                superType.orElse(null),
                subType.orElse(null),
                sort
        );
    }

    public CardResponseDTO getCardById(String id) {
        Card card = cardRepository.findById(id).orElse(null);
        if (card == null) {
            return null;
        }
        return CardResponseMapper.toCardResponse(card);
    }

    public boolean deleteCard(String id) {
        Card card = cardRepository.findById(id).orElse(null);
        if (card == null) {
            return false;
        }
        cardRepository.delete(card);
        return true;
    }
}
