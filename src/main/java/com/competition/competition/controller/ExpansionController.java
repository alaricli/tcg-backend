package com.competition.competition.controller;

import com.competition.competition.dto.ExpansionRequestDTO;
import com.competition.competition.dto.ExpansionResponseDTO;
import com.competition.competition.entity.Expansion;
import com.competition.competition.service.ExpansionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expansion")
public class ExpansionController {

    @Autowired
    private ExpansionService expansionService;

    @PostMapping("/add")
    public ResponseEntity<Expansion> addExpansion(@RequestBody ExpansionRequestDTO expansionRequest) {
        Expansion newExpansion = expansionService.createExpansion(expansionRequest);
        return ResponseEntity.ok(newExpansion);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ExpansionResponseDTO>> getAllExpansions() {
        List<ExpansionResponseDTO> expansions = expansionService.getAllExpansions();
        return ResponseEntity.ok(expansions);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ExpansionResponseDTO> getExpansionById(@PathVariable("id") Long id) {
        ExpansionResponseDTO expansion = expansionService.getExpansionById(id);
        if (expansion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(expansion);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteExpansionById(@PathVariable("id") Long id) {
        try {
            boolean deleted = expansionService.deleteExpansion(id);
            if (deleted) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
