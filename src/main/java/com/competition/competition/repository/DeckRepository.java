package com.competition.competition.repository;

import com.competition.competition.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeckRepository extends JpaRepository<Deck, Long> {
    List<Deck> findByArchetypeId(Long archetypeId);
}
