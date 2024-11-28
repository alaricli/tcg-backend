package com.competition.competition.dto.mapper;

import com.competition.competition.repository.ExpansionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CardRequestMapper {
    @Autowired
    private ExpansionRepository expansionRepository;
}
