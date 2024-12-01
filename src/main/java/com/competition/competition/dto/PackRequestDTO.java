package com.competition.competition.dto;

import com.competition.competition.entity.embeddable.PackImages;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PackRequestDTO {
    @NotBlank
    private String id;
    @NotBlank
    private String name;
    @NotNull
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
