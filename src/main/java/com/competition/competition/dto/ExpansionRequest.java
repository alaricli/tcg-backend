package com.competition.competition.dto;

import com.competition.competition.entity.Card;
import com.competition.competition.enums.Series;

import java.util.List;

public class ExpansionRequest {
    private Long id;
    private Series series;
    private String name;
    private List<Card> cardIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCardIds() {
        return cardIds;
    }

    public void setCardIds(List<Card> cardIds) {
        this.cardIds = cardIds;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }
}
