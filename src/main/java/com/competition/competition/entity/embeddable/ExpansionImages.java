package com.competition.competition.entity.embeddable;

import jakarta.persistence.Embeddable;

@Embeddable
public class ExpansionImages {
    private String symbol;
    private String logo;

    // Getters and setters
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
