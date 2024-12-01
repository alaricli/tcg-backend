package com.competition.competition.dto;

import com.competition.competition.entity.embeddable.PackImages;

public class PackResponseDTO {
    private String id;
    private String name;
    private String expansionId;
    private PackImages packImages;

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

    public String getExpansionId() {
        return expansionId;
    }

    public void setExpansionId(String expansionId) {
        this.expansionId = expansionId;
    }

    public PackImages getPackImages() {
        return packImages;
    }

    public void setPackImages(PackImages packImages) {
        this.packImages = packImages;
    }
}
