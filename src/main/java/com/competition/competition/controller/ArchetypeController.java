package com.competition.competition.controller;

import com.competition.competition.dto.ArchetypeRequestDTO;
import com.competition.competition.dto.ArchetypeResponseDTO;
import com.competition.competition.entity.Archetype;
import com.competition.competition.service.ArchetypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArchetypeController {
    private final ArchetypeService archetypeService;

    public ArchetypeController(ArchetypeService archetypeService) {
        this.archetypeService = archetypeService;
    }

    @PostMapping("/add/archetypes")
    public ResponseEntity<List<Archetype>> addArchetypes(@RequestBody List<ArchetypeRequestDTO> archetypes) {
        List<Archetype> createdArchetypes = archetypeService.createArchetypes(archetypes);
        return new ResponseEntity<>(createdArchetypes, HttpStatus.OK);
    }

    @GetMapping("/get/archetypes")
    public ResponseEntity<List<ArchetypeResponseDTO>> getArchetypes() {
        List<ArchetypeResponseDTO> foundArchetypes = archetypeService.findAllArchetypes();
        return new ResponseEntity<>(foundArchetypes, HttpStatus.OK);
    }

    @GetMapping("/get/archetypes/pocket")
    public ResponseEntity<List<ArchetypeResponseDTO>> getArchetypesPocket() {
        List<ArchetypeResponseDTO> foundArchetypes = archetypeService.findAllArchetypesByCategory("pocket");
        return new ResponseEntity<>(foundArchetypes, HttpStatus.OK);
    }

    @GetMapping("/get/archetype/{id}")
    public ResponseEntity<?> getArchetype(@PathVariable Long id) {
        ArchetypeResponseDTO foundArchetype = archetypeService.findArchetypeById(id);
        if (foundArchetype != null) {
            return new ResponseEntity<>(foundArchetype, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/archetype/{id}")
    public ResponseEntity<?> deleteArchetype(@PathVariable Long id) {
        return new ResponseEntity<>(archetypeService.deleteArchetypeById(id), HttpStatus.OK);
    }
}
