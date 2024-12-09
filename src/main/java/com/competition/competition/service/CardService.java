package com.competition.competition.service;

import com.competition.competition.dto.CardRequestDTO;
import com.competition.competition.dto.CardResponseDTO;
import com.competition.competition.dto.CardResponseSimplifiedDTO;
import com.competition.competition.dto.mapper.CardRequestMapper;
import com.competition.competition.dto.mapper.CardResponseMapper;
import com.competition.competition.entity.Card;
import com.competition.competition.repository.CardRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private CardRequestMapper cardRequestMapper;

    public List<Card> createCards(List<CardRequestDTO> cardRequestDTOList) {
        List<Card> cards = new ArrayList<>();

        for (CardRequestDTO cardRequestDTO : cardRequestDTOList) {
            Card card = cardRequestMapper.requestToCard(cardRequestDTO);
            cards.add(card);
        }

        return cardRepository.saveAll(cards);
    }

    public List<CardResponseSimplifiedDTO> queryCards(String expansionId,
                                                      String packId,
                                                      String searchText,
                                                      String rarity,
                                                      Boolean hasAbility,
                                                      Boolean hasRuleBox,
                                                      String energyType,
                                                      String weakness,
                                                      Integer retreatCost,
                                                      String superType,
                                                      String subType,
                                                      String sortBy,
                                                      String sortDirection
    ) {
        StringBuilder queryBuilder = new StringBuilder("""
                    SELECT c.id, c.name, c.small
                    FROM CARD c
                    LEFT JOIN CARD_SUBTYPES cs ON c.id = cs.card_id
                    LEFT JOIN ENERGY_TYPES e ON c.id = e.card_id
                    LEFT JOIN WEAKNESS_TYPES w ON c.id = w.card_id
                    LEFT JOIN PACK_IDS p ON c.id = p.card_id
                    LEFT JOIN ATTACKS a ON c.id = a.card_id
                    LEFT JOIN RULES r ON c.id = r.card_id
                    WHERE 1=1
                """);

        if (expansionId != null) queryBuilder.append(" AND c.expansion_id = :expansionId");
        if (packId != null) queryBuilder.append("""
                AND EXISTS (
                    SELECT 1
                    FROM PACK_IDS p
                    WHERE p.card_id = c.id
                        AND p.pack_ids = :packId
                        )
                """);
        if (searchText != null)
            queryBuilder.append("""
                        AND (
                            LOWER(c.name) LIKE LOWER(CONCAT('%', :searchText, '%'))
                            OR LOWER(c.artist) LIKE LOWER(CONCAT('%', :searchText, '%'))
                            OR LOWER(c.main_type) LIKE LOWER(CONCAT('%', :searchText, '%'))
                            OR LOWER(c.id) LIKE LOWER(CONCAT('%', :searchText, '%'))
                            OR LOWER(c.super_type) LIKE LOWER(CONCAT('%', :searchText, '%'))
                            OR LOWER(c.ability) LIKE LOWER(CONCAT('%', :searchText, '%'))
                            OR LOWER(c.trainer_card_text) LIKE LOWER(CONCAT('%', :searchText, '%'))
                            OR LOWER(a.text) LIKE LOWER(CONCAT('%', :searchText, '%'))
                            OR LOWER(a.name) LIKE LOWER(CONCAT('%', :searchText, '%'))
                            OR LOWER(a.cost) LIKE LOWER(CONCAT('%', :searchText, '%'))
                        )
                    """);
        if (rarity != null) queryBuilder.append(" AND LOWER(c.rarity) = LOWER(:rarity)");
        if (hasAbility != null) queryBuilder.append(" AND c.has_ability = :hasAbility");
        if (hasRuleBox != null) queryBuilder.append(" AND c.has_rule_box = :hasRuleBox");
        if (energyType != null) queryBuilder.append(" AND c.main_type = :energyType");
        if (weakness != null) queryBuilder.append(" AND w.weakness_types = :weakness");
        if (retreatCost != null) queryBuilder.append(" AND c.retreat_cost = :retreatCost");
        if (superType != null) queryBuilder.append(" AND c.super_type = :superType");
        if (subType != null) queryBuilder.append("""
                AND EXISTS (
                    SELECT 1
                    FROM CARD_SUBTYPES cs
                    WHERE cs.card_id = c.id
                        AND cs.subtypes = :subType
                        )
                """);

        String sortColumn = switch (sortBy == null ? "CAST(c.card_number AS INTEGER)" : sortBy) {
            case "name" -> "c.name";
            case "rarity" -> """
                    CASE c.rarity
                        WHEN 'Common' THEN 1
                        WHEN 'Uncommon' THEN 2
                        WHEN 'Rare' THEN 3
                        WHEN 'Double Rare' THEN 4
                        WHEN 'Art Rare' THEN 5
                        WHEN 'Super Rare' THEN 6
                        WHEN 'Special Art Rare' THEN 7
                        WHEN 'Immersive Rare' THEN 8
                        WHEN 'Crown Rare' THEN 9
                        ELSE 10 -- To handle unexpected rarities
                    END
                    """;
            case "superType" -> "c.super_type";
            case "type" -> "c.main_type";
            case "nationalDexNumber" -> "c.national_dex_number";
            default -> "CAST(c.card_number AS INTEGER)";
        };
        String safeSortDirection = "DESC".equalsIgnoreCase(sortDirection) ? "DESC" : "ASC";
        queryBuilder.append(" ORDER BY ").append(sortColumn).append(" ").append(safeSortDirection);

        Query query = em.createNativeQuery(queryBuilder.toString(), CardResponseSimplifiedDTO.class);

        if (expansionId != null) query.setParameter("expansionId", expansionId);
        if (packId != null) query.setParameter("packId", packId);
        if (searchText != null) query.setParameter("searchText", searchText);
        if (rarity != null) query.setParameter("rarity", rarity);
        if (hasAbility != null) query.setParameter("hasAbility", hasAbility);
        if (hasRuleBox != null) query.setParameter("hasRuleBox", hasRuleBox);
        if (energyType != null) query.setParameter("energyType", energyType);
        if (weakness != null) query.setParameter("weakness", weakness);
        if (retreatCost != null) query.setParameter("retreatCost", retreatCost);
        if (superType != null) query.setParameter("superType", superType);
        if (subType != null) query.setParameter("subType", subType);

        return query.getResultList();
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
