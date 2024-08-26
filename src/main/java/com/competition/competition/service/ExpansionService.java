package com.competition.competition.service;

import com.competition.competition.dto.ExpansionRequest;
import com.competition.competition.entity.Expansion;
import com.competition.competition.repository.CardRepository;
import com.competition.competition.repository.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpansionService {

    @Autowired
    private ExpansionRepository expansionRepository;
    @Autowired
    private CardRepository cardRepository;

    public List<Expansion> getAllExpansions() {
        return expansionRepository.findAll();
    }

    public Expansion getExpansionById(Long id) {
        return expansionRepository.findById(id).orElse(null);
    }

    public Expansion createExpansion(ExpansionRequest expansionRequest) {
        if (expansionRepository.existsBySeriesAndName(expansionRequest.getSeries(), expansionRequest.getName())) {
            throw new RuntimeException("Expansion already exists");
        }

        Expansion expansion = makeExpansion(expansionRequest);
        return expansionRepository.save(expansion);
    }

    // HELPERS
    private Expansion makeExpansion(ExpansionRequest expansionRequest) {
        Expansion newExpansion = new Expansion();
        updateExpansionFromRequest(newExpansion, expansionRequest);
        return newExpansion;
    }

    private void updateExpansionFromRequest(Expansion expansion, ExpansionRequest expansionRequest) {
        expansion.setSeries(expansionRequest.getSeries());
        expansion.setName(expansionRequest.getName());
    }
}
