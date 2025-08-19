package com.example.recipe.cooker.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "favorites")
@Data
public class Favorite {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public Long id;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "user_id", nullable = false)
public User user;

@ManyToOne
@JoinColumn(name = "recipe_id", nullable = false)
public Recipe recipe;


}
