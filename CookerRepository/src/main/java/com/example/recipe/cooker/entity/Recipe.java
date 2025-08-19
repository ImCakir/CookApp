package com.example.recipe.cooker.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "recipes")
@Data
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false)
    public String area;

    @Column(nullable = false)
    public String category;

    @Column
    public String imageUrl;

    @ElementCollection
    @CollectionTable(
            name = "recipe_ingredients",
            joinColumns = @JoinColumn(name = "recipe_id")
    )
    @Column(name = "ingredients")
    public List<String> ingredients;

    @ElementCollection
    @CollectionTable(
            name = "recipe_instructions",
            joinColumns = @JoinColumn(name = "recipe_id")
    )
    @Column(name = "instruction")
    public List<String> instructions;

    @Column(nullable = false)
    public LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe", cascade = CascadeType.ALL)
    public List<Favorite> favorites;

}
