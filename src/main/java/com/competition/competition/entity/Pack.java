package com.competition.competition.entity;

import com.competition.competition.entity.embeddable.PackImages;
import jakarta.persistence.*;

@Entity
@Table(name = "pack")
public class Pack {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "expansion_id")
    private Expansion expansion;
    @Embedded
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

    public Expansion getExpansion() {
        return expansion;
    }

    public void setExpansion(Expansion expansion) {
        this.expansion = expansion;
    }

    public PackImages getPackImages() {
        return packImages;
    }

    public void setPackImages(PackImages packImages) {
        this.packImages = packImages;
    }
}
