package com.competition.competition.entity.embeddable;

import jakarta.persistence.Embeddable;

@Embeddable
public class Legalities {
    private boolean unlimited;
    private boolean expanded;
    private boolean standard;

    public boolean isUnlimited() {
        return unlimited;
    }

    public void setUnlimited(boolean unlimited) {
        this.unlimited = unlimited;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isStandard() {
        return standard;
    }

    public void setStandard(boolean standard) {
        this.standard = standard;
    }
}
