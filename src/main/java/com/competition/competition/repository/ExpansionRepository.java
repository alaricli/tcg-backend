package com.competition.competition.repository;

import com.competition.competition.entity.Expansion;
import com.competition.competition.enums.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpansionRepository extends JpaRepository<Expansion, String> {
    boolean existsBySeriesAndName(Series series, String name);
}
