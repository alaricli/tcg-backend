package com.competition.competition.dto.mapper;

import com.competition.competition.dto.ArchetypeRequestDTO;
import com.competition.competition.entity.Archetype;

public class ArchetypeRequestMapper {
    public static Archetype map(ArchetypeRequestDTO archetypeRequestDTO) {
        Archetype archetype = new Archetype();
        archetype.setName(archetypeRequestDTO.getName());
        archetype.setTier(archetypeRequestDTO.getTier());
        archetype.setRanking(archetypeRequestDTO.getRanking());
        archetype.setImage(archetypeRequestDTO.getImage());
        archetype.setWins(archetypeRequestDTO.getWins());
        archetype.setCategory(archetypeRequestDTO.getCategory());
        archetype.setPokemons(archetypeRequestDTO.getPokemons());
        archetype.setPokemonsImages(archetypeRequestDTO.getPokemonsImages());
        archetype.setEnergyTypesIcons(archetypeRequestDTO.getEnergyTypesIcons());

        return archetype;
    }
}
