package com.competition.competition.entity;

import com.competition.competition.enums.Rarity;
import com.competition.competition.enums.Stage;
import com.competition.competition.enums.Type;
import jakarta.persistence.*;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer hp;
    private String name;
    private String set;
    private String artist;
    private Boolean ability;
    private Float price;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Type weakness;
    @Enumerated(EnumType.STRING)
    private Type resistance;
    @Enumerated(EnumType.STRING)
    private Stage stage;
    @Enumerated(EnumType.STRING)
    private Rarity rarity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}