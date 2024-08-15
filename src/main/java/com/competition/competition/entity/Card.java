package com.competition.competition.entity;

import com.competition.competition.enums.Category;
import com.competition.competition.enums.Rarity;
import com.competition.competition.enums.Stage;
import com.competition.competition.enums.Type;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer hp;
    private String name;
    private String artist;
    private Boolean ability;
    private Float price;
    @Enumerated(EnumType.STRING)
    private Category category;
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
    @ManyToOne
    @JoinColumn(name = "set_id", nullable = false)
    private Set set;
    @ManyToMany(mappedBy = "cards")
    private List<Deck> decks;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}