package com.competition.competition.controller;

import com.competition.competition.dto.ExpansionRequestDTO;
import com.competition.competition.dto.ExpansionResponseDTO;
import com.competition.competition.entity.Expansion;
import com.competition.competition.service.ExpansionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpansionController {
    private final ExpansionService expansionService;

    public ExpansionController(ExpansionService expansionService) {
        this.expansionService = expansionService;
    }

    @PostMapping("/add/expansions")
    public ResponseEntity<List<Expansion>> addExpansions(@RequestBody List<ExpansionRequestDTO> expansionRequests) {
        List<Expansion> newExpansions = expansionService.createExpansions(expansionRequests);
        return ResponseEntity.ok(newExpansions);
    }

    @GetMapping("/get/expansions")
    public ResponseEntity<List<ExpansionResponseDTO>> getAllExpansions() {
        List<ExpansionResponseDTO> expansions = expansionService.getAllExpansions();
        return ResponseEntity.ok(expansions);
    }

    @GetMapping("/get/expansion/{id}")
    public ResponseEntity<ExpansionResponseDTO> getExpansionById(@PathVariable("id") String id) {
        ExpansionResponseDTO expansion = expansionService.getExpansionById(id);
        if (expansion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(expansion);
    }

    @GetMapping("/get/expansions/pocket")
    public ResponseEntity<List<ExpansionResponseDTO>> getPocketExpansions() {
        List<ExpansionResponseDTO> expansions = expansionService.getAllPocketExpansions();
        return ResponseEntity.ok(expansions);
    }

    @DeleteMapping("/delete/expansion/{id}")
    public ResponseEntity<String> deleteExpansionById(@PathVariable("id") String id) {
        try {
            boolean deleted = expansionService.deleteExpansion(id);
            if (deleted) {
                return new ResponseEntity<>("deleted", HttpStatus.OK);
            }
            return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
        } catch (RuntimeException e) {
            return new ResponseEntity<>("error" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
