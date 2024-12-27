package com.competition.competition.dto.mapper;

import com.competition.competition.dto.ArchetypeResponseDTO;
import com.competition.competition.entity.Archetype;

public class ArchetypeResponseMapper {
    public static ArchetypeResponseDTO map(Archetype archetype) {
        ArchetypeResponseDTO archetypeResponseDTO = new ArchetypeResponseDTO();
        archetypeResponseDTO.setId(archetype.getId());
        archetypeResponseDTO.setName(archetype.getName());
        archetypeResponseDTO.setTier(archetype.getTier());
        archetypeResponseDTO.setRanking(archetype.getRanking());
        archetypeResponseDTO.setWins(archetype.getWins());
        archetypeResponseDTO.setImage(archetype.getImage());
        archetypeResponseDTO.setCategory(archetype.getCategory());
        archetypeResponseDTO.setPokemons(archetype.getPokemons());
        archetypeResponseDTO.setPokemonsImages(archetype.getPokemonsImages());
        archetypeResponseDTO.setEnergyTypesIcons(archetype.getEnergyTypesIcons());
        return archetypeResponseDTO;
    }
}
