package com.competition.competition.dto.mapper;

import com.competition.competition.dto.ExpansionResponseDTO;
import com.competition.competition.entity.Expansion;

public class ExpansionResponseMapper {
    public static ExpansionResponseDTO toExpansionResponse(Expansion expansion) {
        ExpansionResponseDTO expansionResponse = new ExpansionResponseDTO();
        expansionResponse.setId(expansion.getId());
        expansionResponse.setName(expansion.getName());
        expansionResponse.setSeries(expansion.getSeries());
        expansionResponse.setExpansionCode(expansion.getExpansionCode());
        expansionResponse.setPrintedTotal(expansion.getPrintedTotal());
        expansionResponse.setTotal(expansion.getTotal());
        expansionResponse.setExpansionImages(expansion.getExpansionImages());
        expansionResponse.setLegalities(expansion.getLegalities());
        expansionResponse.setReleaseDate(expansion.getReleaseDate());

        return expansionResponse;
    }
}
