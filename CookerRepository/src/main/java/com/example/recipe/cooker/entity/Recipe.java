package com.example.recipe.cooker.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "meals", indexes = {
        @Index(name = "ix_meals_category", columnList = "category"),
        @Index(name = "ix_meals_area", columnList = "area")
})
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@EqualsAndHashCode(of = "idMeal")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id", nullable = false, updatable = false, length = 64)
    private Long id;


    @Column(name = "id_meal", length = 255)
    private String idMeal;

    @Column(name = "meal_name", length = 255)
    private String strMeal;

    @Column(name = "meal_alternate", length = 255)
    private String strMealAlternate;

    @Column(name = "category", length = 100)
    private String strCategory;

    @Column(name = "area", length = 100)
    private String strArea;

    @Column(name = "instructions", columnDefinition = "TEXT")
    private String strInstructions;

    @Column(name = "meal_thumb", length = 512)
    private String strMealThumb;

    @Column(name = "tags", length = 255)
    private String strTags;

    @Column(name = "youtube", length = 512)
    private String strYoutube;

    // Ingredients (1..20)
    @Column(length = 255) private String strIngredient1;
    @Column(length = 255) private String strIngredient2;
    @Column(length = 255) private String strIngredient3;
    @Column(length = 255) private String strIngredient4;
    @Column(length = 255) private String strIngredient5;
    @Column(length = 255) private String strIngredient6;
    @Column(length = 255) private String strIngredient7;
    @Column(length = 255) private String strIngredient8;
    @Column(length = 255) private String strIngredient9;
    @Column(length = 255) private String strIngredient10;
    @Column(length = 255) private String strIngredient11;
    @Column(length = 255) private String strIngredient12;
    @Column(length = 255) private String strIngredient13;
    @Column(length = 255) private String strIngredient14;
    @Column(length = 255) private String strIngredient15;
    @Column(length = 255) private String strIngredient16;
    @Column(length = 255) private String strIngredient17;
    @Column(length = 255) private String strIngredient18;
    @Column(length = 255) private String strIngredient19;
    @Column(length = 255) private String strIngredient20;

    // Measures (1..20)
    @Column(length = 255) private String strMeasure1;
    @Column(length = 255) private String strMeasure2;
    @Column(length = 255) private String strMeasure3;
    @Column(length = 255) private String strMeasure4;
    @Column(length = 255) private String strMeasure5;
    @Column(length = 255) private String strMeasure6;
    @Column(length = 255) private String strMeasure7;
    @Column(length = 255) private String strMeasure8;
    @Column(length = 255) private String strMeasure9;
    @Column(length = 255) private String strMeasure10;
    @Column(length = 255) private String strMeasure11;
    @Column(length = 255) private String strMeasure12;
    @Column(length = 255) private String strMeasure13;
    @Column(length = 255) private String strMeasure14;
    @Column(length = 255) private String strMeasure15;
    @Column(length = 255) private String strMeasure16;
    @Column(length = 255) private String strMeasure17;
    @Column(length = 255) private String strMeasure18;
    @Column(length = 255) private String strMeasure19;
    @Column(length = 255) private String strMeasure20;

    @Column(name = "source", length = 512)
    private String strSource;

    @Column(name = "image_source", length = 512)
    private String strImageSource;

    @Column(name = "creative_commons_confirmed", length = 50)
    private String strCreativeCommonsConfirmed;

    @Column(name = "date_modified", length = 50)
    private String dateModified;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe", cascade = CascadeType.ALL)
    private List<Favorite> favorites;

    public Recipe(String strMeal) {
        this.strMeal = strMeal;
    }
}
