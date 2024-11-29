package com.competition.competition.dto.mapper;

import com.competition.competition.dto.ExpansionRequestDTO;
import com.competition.competition.entity.Expansion;

public class ExpansionRequestMapper {
    public Expansion requestToExpansion(ExpansionRequestDTO expansionRequestDTO) {
        Expansion expansion = new Expansion();
        expansion.setId(expansionRequestDTO.getId());
        expansion.setName(expansionRequestDTO.getName());
        expansion.setSeries(expansionRequestDTO.getSeries());
        expansion.setExpansionCode(expansionRequestDTO.getExpansionCode());
        expansion.setPrintedTotal(expansionRequestDTO.getPrintedTotal());
        expansion.setTotal(expansionRequestDTO.getTotal());
        expansion.setExpansionImages(expansionRequestDTO.getExpansionImages());
        expansion.setLegalities(expansionRequestDTO.getLegalities());
        expansion.setReleaseDate(expansionRequestDTO.getReleaseDate());

        return expansion;
    }
}
