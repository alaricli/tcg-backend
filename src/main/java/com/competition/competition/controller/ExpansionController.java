package com.competition.competition.controller;

import com.competition.competition.dto.ExpansionRequest;
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

    @PostMapping("/addExpansions")
    public ResponseEntity<Expansion> addExpansion(@RequestBody ExpansionRequest expansionRequest) {
        Expansion newExpansion = expansionService.createExpansion(expansionRequest);
        return ResponseEntity.ok(newExpansion);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Expansion>> getAllExpansions() {
        return ResponseEntity.ok(expansionService.getAllExpansions());
    }
}
