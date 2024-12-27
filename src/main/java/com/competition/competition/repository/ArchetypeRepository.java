package com.competition.competition.repository;

import com.competition.competition.entity.Archetype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchetypeRepository extends JpaRepository<Archetype, Long> {
    List<Archetype> findAllByCategory(String category);
}
