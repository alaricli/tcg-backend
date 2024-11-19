package com.competition.competition.controller;

import com.competition.competition.dto.ExpansionRequest;
import com.competition.competition.dto.ExpansionResponse;
import com.competition.competition.entity.Expansion;
import com.competition.competition.service.ExpansionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expansion")
public class ExpansionController {

    // TODO: edit expansion by ID

    @Autowired
    private ExpansionService expansionService;

    @PostMapping("/add")
    public ResponseEntity<Expansion> addExpansion(@RequestBody ExpansionRequest expansionRequest) {
        Expansion newExpansion = expansionService.createExpansion(expansionRequest);
        return ResponseEntity.ok(newExpansion);
    }

    @GetMapping("/get")
    public ResponseEntity<List<ExpansionResponse>> getAllExpansions() {
        List<ExpansionResponse> expansions = expansionService.getAllExpansions();
        return ResponseEntity.ok(expansions);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ExpansionResponse> getExpansionById(@PathVariable("id") Long id) {
        ExpansionResponse expansion = expansionService.getExpansionById(id);
        if (expansion == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(expansion);
    }

//    @PutMapping("/put/{id}")
//    public ResponseEntity<ExpansionResponse> updateExpansion(@PathVariable("id") Long id, @RequestBody ExpansionRequest expansionRequest) {
//        try {
//            ExpansionResponse updatedExpansion = expansionService.updateExpansion(id, expansionRequest);
//            if (updatedExpansion == null) {
//                return ResponseEntity.notFound().build();
//            }
//            return ResponseEntity.ok(updatedExpansion);
//        } catch (RuntimeException e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteExpansionById(@PathVariable("id") Long id) {
        try {
            boolean deleted = expansionService.deleteExpansion(id);
            if (!deleted) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
