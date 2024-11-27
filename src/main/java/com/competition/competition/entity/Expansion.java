package com.competition.competition.entity;

import com.competition.competition.entity.card.Card;
import com.competition.competition.entity.embeddable.ExpansionImages;
import com.competition.competition.entity.embeddable.Legalities;
import com.competition.competition.enums.ExpansionCode;
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

    @Embedded
    private ExpansionImages expansionImages;

    @Embedded
    private Legalities legalities;

    private Integer printedTotal;

    private Integer total;

    @Enumerated(EnumType.STRING)
    private ExpansionCode expansionCode;

    private String releaseDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExpansionImages getExpansionImages() {
        return expansionImages;
    }

    public void setExpansionImages(ExpansionImages expansionImages) {
        this.expansionImages = expansionImages;
    }

    public Legalities getLegalities() {
        return legalities;
    }

    public void setLegalities(Legalities legalities) {
        this.legalities = legalities;
    }

    public Integer getPrintedTotal() {
        return printedTotal;
    }

    public void setPrintedTotal(Integer printedTotal) {
        this.printedTotal = printedTotal;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public ExpansionCode getExpansionCode() {
        return expansionCode;
    }

    public void setExpansionCode(ExpansionCode expansionCode) {
        this.expansionCode = expansionCode;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}