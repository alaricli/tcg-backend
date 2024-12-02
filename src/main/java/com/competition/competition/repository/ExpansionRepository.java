package com.competition.competition.repository;

import com.competition.competition.entity.Expansion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpansionRepository extends JpaRepository<Expansion, String> {
    boolean existsBySeriesAndName(String series, String name);
    List<Expansion> findAllBySeries(String series);
}
