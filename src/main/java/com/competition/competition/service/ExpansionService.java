package com.competition.competition.service;

import com.competition.competition.dto.ExpansionRequestDTO;
import com.competition.competition.dto.ExpansionResponseDTO;
import com.competition.competition.dto.mapper.ExpansionRequestMapper;
import com.competition.competition.dto.mapper.ExpansionResponseMapper;
import com.competition.competition.entity.Expansion;
import com.competition.competition.repository.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpansionService {

    @Autowired
    private ExpansionRepository expansionRepository;

    public List<ExpansionResponseDTO> getAllExpansions() {
        return expansionRepository.findAll().stream()
                .map(ExpansionResponseMapper::toExpansionResponse)
                .collect(Collectors.toList());
    }

    public ExpansionResponseDTO getExpansionById(Long id) {
        Expansion expansion = expansionRepository.findById(id).orElse(null);
        if (expansion == null) {
            return null;
        }
        return ExpansionResponseMapper.toExpansionResponse(expansion);
    }

    public Expansion createExpansion(ExpansionRequestDTO expansionRequest) {
        if (expansionRepository.existsBySeriesAndName(expansionRequest.getSeries(), expansionRequest.getName())) {
            throw new RuntimeException("Expansion already exists");
        }

        Expansion expansion = ExpansionRequestMapper.requestToExpansion(expansionRequest);
        return expansionRepository.save(expansion);
    }

    public boolean deleteExpansion(Long id) {
        Expansion expansion = expansionRepository.findById(id).orElse(null);
        if (expansion == null) {
            return false;
        }
        expansionRepository.delete(expansion);
        return true;
    }
}
