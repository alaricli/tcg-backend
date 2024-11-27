package com.competition.competition.entity.embeddable;

import jakarta.persistence.Embeddable;

@Embeddable
public class CardImages {
    private String small;
    private String large;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
