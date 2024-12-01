package com.competition.competition.service;

import com.competition.competition.dto.PackRequestDTO;
import com.competition.competition.dto.PackResponseDTO;
import com.competition.competition.entity.Pack;
import com.competition.competition.repository.ExpansionRepository;
import com.competition.competition.repository.PackRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PackService {
    @Autowired
    private PackRepository packRepository;
    @Autowired
    private ExpansionRepository expansionRepository;

    @Transactional
    public List<Pack> createPacks(List<PackRequestDTO> packRequestDTOList) {
        List<Pack> packList = new ArrayList<>();
        for (PackRequestDTO packRequestDTO : packRequestDTOList) {
            Pack pack = new Pack();
            pack.setName(packRequestDTO.getName());
            pack.setId(packRequestDTO.getId());
            pack.setPackImages(packRequestDTO.getPackImages());
            pack.setExpansion(expansionRepository.findById(packRequestDTO.getExpansionId()).orElseThrow(() -> new IllegalArgumentException("Expansion not found")));
            packList.add(pack);
        }
        return packRepository.saveAll(packList);
    }

    public List<PackResponseDTO> getAllPacks() {
        return packRepository.findAll().stream()
                .map(pack -> {
                    PackResponseDTO responseDTO = new PackResponseDTO();
                    responseDTO.setId(pack.getId());
                    responseDTO.setName(pack.getName());
                    responseDTO.setExpansionId(pack.getExpansion().getId());
                    responseDTO.setPackImages(pack.getPackImages());
                    return responseDTO;
                })
                .toList();
    }
}
