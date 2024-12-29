package com.competition.competition.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "deck")
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "archetype_id", nullable = false)
    private Archetype archetype;
    private String name;
    private String author;
    private Float totalPrice;
    private String image;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String variant;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "deck_variant_pokemons", joinColumns = @JoinColumn(name = "deck_id"))
    @Column(name = "deck_variant_pokemons")
    private List<String> variant_pokemons;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "deck_variant_pokemons_images", joinColumns = @JoinColumn(name = "deck_id"))
    @Column(name = "deck_variant_pokemons_images")
    private List<String> variant_pokemons_images;


    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeckCard> cards;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<DeckCard> getCards() {
        return cards;
    }

    public void setCards(List<DeckCard> cards) {
        this.cards = cards;
    }

    public Archetype getArchetype() {
        return archetype;
    }

    public void setArchetype(Archetype archetype) {
        this.archetype = archetype;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public List<String> getVariant_pokemons() {
        return variant_pokemons;
    }

    public void setVariant_pokemons(List<String> variant_pokemons) {
        this.variant_pokemons = variant_pokemons;
    }

    public List<String> getVariant_pokemons_images() {
        return variant_pokemons_images;
    }

    public void setVariant_pokemons_images(List<String> variant_pokemons_images) {
        this.variant_pokemons_images = variant_pokemons_images;
    }
}