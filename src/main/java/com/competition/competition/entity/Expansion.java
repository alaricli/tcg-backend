package com.competition.competition.entity;

import com.competition.competition.entity.card.Card;
import com.competition.competition.enums.Series;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "expansion", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"series", "name"})
})
public class Expansion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "series", nullable = false)
    private Series series;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "expansion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Card> cards;

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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }
}