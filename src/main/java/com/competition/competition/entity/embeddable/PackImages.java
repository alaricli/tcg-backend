package com.competition.competition.entity.embeddable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PackImages {
    private String packLogo;
    private String packImage;

    public String getPackLogo() {
        return packLogo;
    }

    public void setPackLogo(String packLogo) {
        this.packLogo = packLogo;
    }

    public String getPackImage() {
        return packImage;
    }

    public void setPackImage(String packImage) {
        this.packImage = packImage;
    }
}
