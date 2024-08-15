package com.competition.competition.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "set")
public class Set {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "set", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Card> cards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}