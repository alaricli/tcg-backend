package com.competition.competition.service;

import com.competition.competition.dto.ArchetypeRequestDTO;
import com.competition.competition.dto.ArchetypeResponseDTO;
import com.competition.competition.dto.mapper.ArchetypeRequestMapper;
import com.competition.competition.dto.mapper.ArchetypeResponseMapper;
import com.competition.competition.entity.Archetype;
import com.competition.competition.repository.ArchetypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArchetypeService {
    @Autowired
    private ArchetypeRepository archetypeRepository;

    public List<Archetype> createArchetypes(List<ArchetypeRequestDTO> archetypeRequests) {
        List<Archetype> archetypes = new ArrayList<>();

        for (ArchetypeRequestDTO archetypeRequest : archetypeRequests) {
            Archetype archetype = ArchetypeRequestMapper.map(archetypeRequest);
            archetypes.add(archetype);
        }

        return archetypeRepository.saveAll(archetypes);
    }

    public List<ArchetypeResponseDTO> findAllArchetypesByCategory(String category) {
        List<ArchetypeResponseDTO> archetypeResponses = new ArrayList<>();
        List<Archetype> archetypes = archetypeRepository.findAllByCategory(category);

        for (Archetype archetype : archetypes) {
            ArchetypeResponseDTO archetypeResponse = ArchetypeResponseMapper.map(archetype);
            archetypeResponses.add(archetypeResponse);
        }

        return archetypeResponses;
    }

    public List<ArchetypeResponseDTO> findAllArchetypes() {
        List<ArchetypeResponseDTO> archetypeResponses = new ArrayList<>();
        List<Archetype> archetypes = archetypeRepository.findAll();

        for (Archetype archetype : archetypes) {
            ArchetypeResponseDTO archetypeResponse = ArchetypeResponseMapper.map(archetype);
            archetypeResponses.add(archetypeResponse);
        }

        return archetypeResponses;
    }

    public ArchetypeResponseDTO findArchetypeById(Long id) {
        Archetype archetype = archetypeRepository.findById(id).orElse(null);
        if (archetype != null) {
            return ArchetypeResponseMapper.map(archetype);
        }
        return null;
    }

    public String deleteArchetypeById(Long id) {
        archetypeRepository.deleteById(id);
        return "Deleted Archetype";
    }
}
