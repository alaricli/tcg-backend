package com.competition.competition.entity.embeddable;

import jakarta.persistence.Embeddable;

@Embeddable
public class Legalities {
    private String unlimited;
    private String expanded;
    private String standard;

    public String getUnlimited() {
        return unlimited;
    }

    public void setUnlimited(String unlimited) {
        this.unlimited = unlimited;
    }

    public String getExpanded() {
        return expanded;
    }

    public void setExpanded(String expanded) {
        this.expanded = expanded;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }
}
