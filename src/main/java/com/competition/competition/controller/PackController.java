package com.competition.competition.controller;

import com.competition.competition.dto.PackRequestDTO;
import com.competition.competition.dto.PackResponseDTO;
import com.competition.competition.entity.Pack;
import com.competition.competition.service.CardService;
import com.competition.competition.service.PackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PackController {
    private final PackService packService;

    public PackController(PackService packService, CardService cardService) {
        this.packService = packService;
    }

    @PostMapping("/add/packs")
    public ResponseEntity<?> addPacks(@RequestBody List<PackRequestDTO> packRequestDTOList) {
        try {
            List<Pack> newPacks = packService.createPacks(packRequestDTOList);
            return new ResponseEntity<>(newPacks, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/packs")
    public ResponseEntity<List<PackResponseDTO>> getPacks() {
        List<PackResponseDTO> returnPacks = packService.getAllPacks();
        return new ResponseEntity<>(returnPacks, HttpStatus.OK);
    }

    @DeleteMapping("/delete/pack/{id}")
    public ResponseEntity<String> deletePack(@PathVariable String id) {
        try {
            boolean deleted = packService.deletePack(id);
            if (deleted) {
                return new ResponseEntity<>("deleted", HttpStatus.OK);
            }
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
