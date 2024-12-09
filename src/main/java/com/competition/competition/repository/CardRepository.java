package com.competition.competition.repository;

import com.competition.competition.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// TODO: expand text matching search to name, attack, ability, trainer_card_text, main_type, artist, description

@Repository
public interface CardRepository extends JpaRepository<Card, String> {
}
