package com.competition.competition.dto.mapper;

import com.competition.competition.dto.ExpansionResponse;
import com.competition.competition.dto.cardresponse.CardResponse;
import com.competition.competition.entity.Expansion;

import java.util.List;
import java.util.stream.Collectors;

public class ExpansionResponseMapper {
    public static ExpansionResponse toExpansionResponse(Expansion expansion) {
        ExpansionResponse expansionResponse = new ExpansionResponse();
        expansionResponse.setId(expansion.getId());
        expansionResponse.setName(expansion.getName());
        expansionResponse.setSeries(expansion.getSeries());

        List<CardResponse> cardResponses = expansion.getCards().stream()
                .map(CardResponseMapper::toCardResponse)
                .collect(Collectors.toList());

        expansionResponse.setCards(cardResponses);
        return expansionResponse;
    }
}
