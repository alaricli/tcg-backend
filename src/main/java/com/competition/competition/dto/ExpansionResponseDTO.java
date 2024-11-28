package com.competition.competition.dto;

import com.competition.competition.entity.embeddable.ExpansionImages;
import com.competition.competition.entity.embeddable.Legalities;
import com.competition.competition.enums.ExpansionCode;
import com.competition.competition.enums.Series;

public class ExpansionResponseDTO {
    private String id;
    private Series series;
    private String name;
    private ExpansionImages expansionImages;
    private Legalities legalities;
    private Integer printedTotal;
    private Integer total;
    private ExpansionCode expansionCode;
    private String releaseDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
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
