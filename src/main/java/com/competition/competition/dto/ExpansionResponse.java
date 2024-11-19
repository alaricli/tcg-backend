package com.competition.competition.dto;

import com.competition.competition.dto.cardresponse.CardResponse;
import com.competition.competition.enums.Series;

import java.util.List;

public class ExpansionResponse {
    private Long id;
    private Series series;
    private String name;
    private List<CardResponse> cards;

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

    public List<CardResponse> getCards() {
        return cards;
    }

    public void setCards(List<CardResponse> cards) {
        this.cards = cards;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }
}
