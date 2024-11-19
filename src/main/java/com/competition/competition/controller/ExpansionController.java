package com.competition.competition.controller;

import com.competition.competition.dto.ExpansionRequest;
import com.competition.competition.dto.ExpansionResponse;
import com.competition.competition.entity.Expansion;
import com.competition.competition.service.ExpansionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expansion")
public class ExpansionController {

    // TODO: get expansion by ID
    // TODO: delete expansion by ID

    @Autowired
    private ExpansionService expansionService;

    @PostMapping("/add")
    public ResponseEntity<Expansion> addExpansion(@RequestBody ExpansionRequest expansionRequest) {
        Expansion newExpansion = expansionService.createExpansion(expansionRequest);
        return ResponseEntity.ok(newExpansion);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<ExpansionResponse>> getAllExpansions() {
        List<ExpansionResponse> expansions = expansionService.getAllExpansions();
        return ResponseEntity.ok(expansions);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/test2")
    public ResponseEntity<List<Expansion>> getAllExpansions2() {
        return ResponseEntity.ok(expansionService.getAllExpansionsWorking());
    }
}
