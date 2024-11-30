package com.competition.competition.entity;

import com.competition.competition.entity.embeddable.ExpansionImages;
import com.competition.competition.entity.embeddable.Legalities;
import jakarta.persistence.*;

@Entity
@Table(name = "expansion", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"series", "name"})
})
public class Expansion {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "series", nullable = false)
    private String series;
    @Column(name = "name", nullable = false)
    private String name;
    @Embedded
    private ExpansionImages expansionImages;
    @Embedded
    private Legalities legalities;
    private Integer printedTotal;
    private Integer total;
    private String expansionCode;
    private String releaseDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
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

    public String getExpansionCode() {
        return expansionCode;
    }

    public void setExpansionCode(String expansionCode) {
        this.expansionCode = expansionCode;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}