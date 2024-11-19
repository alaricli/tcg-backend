package com.competition.competition.service;

import com.competition.competition.dto.ExpansionRequest;
import com.competition.competition.dto.ExpansionResponse;
import com.competition.competition.dto.cardresponse.CardResponse;
import com.competition.competition.dto.mapper.CardResponseMapper;
import com.competition.competition.entity.Expansion;
import com.competition.competition.repository.CardRepository;
import com.competition.competition.repository.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpansionService {

    @Autowired
    private ExpansionRepository expansionRepository;

    public List<ExpansionResponse> getAllExpansions() {
        return expansionRepository.findAll().stream()
                .map(this::mapExpansionToResponse)
                .collect(Collectors.toList());
    }

    public ExpansionResponse getExpansionById(Long id) {
        Expansion expansion = expansionRepository.findById(id).orElse(null);
        if (expansion == null) {
            return null;
        }
        return mapExpansionToResponse(expansion);
    }

    public Expansion createExpansion(ExpansionRequest expansionRequest) {
        if (expansionRepository.existsBySeriesAndName(expansionRequest.getSeries(), expansionRequest.getName())) {
            throw new RuntimeException("Expansion already exists");
        }

        Expansion expansion = makeExpansion(expansionRequest);
        return expansionRepository.save(expansion);
    }

    // Helper Functions
    private Expansion makeExpansion(ExpansionRequest expansionRequest) {
        Expansion newExpansion = new Expansion();
        updateExpansionFromRequest(newExpansion, expansionRequest);
        return newExpansion;
    }

    private void updateExpansionFromRequest(Expansion expansion, ExpansionRequest expansionRequest) {
        expansion.setSeries(expansionRequest.getSeries());
        expansion.setName(expansionRequest.getName());
    }

    private ExpansionResponse mapExpansionToResponse(Expansion expansion) {
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
