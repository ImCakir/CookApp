package com.example.recipe.cooker;


import com.example.recipe.cooker.dto.Meal;
import com.example.recipe.cooker.dto.Root;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
public class CookerTheMeal {
    private final RestTemplate restTemplate;
    private static final String THE_MEAL_API_URL_TEMPLATE =
            "https://www.themealdb.com/api/json/v1/1/search.php?s=%s";

    public CookerTheMeal(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public Root getRoot(String meal)
    {
        return restTemplate.getForObject(String.format(THE_MEAL_API_URL_TEMPLATE, meal),Root.class);
    }

    public Iterable<Meal> getMealInList(String meal)
    {
        Root root = getRoot(meal);
        return root != null ? root.getMeals() : List.of();
    }

    public List<Meal> searchMeals(String meal) {
        Root root = getRoot(meal);
        return root != null ? root.getMeals() : Collections.emptyList();
    }
}





