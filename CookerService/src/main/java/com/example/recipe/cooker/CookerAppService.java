package com.example.recipe.cooker;


import com.example.recipe.CookerTheMeal;
import com.example.recipe.cooker.dal.CookerRepositoryHelper;
import com.example.recipe.cooker.dto.RecipeDto;
import com.example.recipe.cooker.mapper.CookerServiceMapper;
import com.example.recipe.dto.Meal;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CookerAppService {
    private final CookerServiceMapper cookerServiceMapper;
    private final CookerRepositoryHelper cookerRepositoryHelper;
    private final CookerTheMeal cookerTheMeal;

    public CookerAppService(CookerServiceMapper cookerServiceMapper,
                            CookerRepositoryHelper cookerRepositoryHelper
                            , CookerTheMeal cookerTheMeal) {

        this.cookerServiceMapper = cookerServiceMapper;
        this.cookerRepositoryHelper = cookerRepositoryHelper;
        this.cookerTheMeal = cookerTheMeal;

    }

    public List<RecipeDto> searchRecipes(String meal) {
        List<Meal> meals = cookerTheMeal.searchMeals(meal);
        return meals.stream()
                .map(cookerServiceMapper::mealToDto)//mealdto recipedto ya donusturuluyor.
                .collect(Collectors.toList());//collect verileri toplar, toList ile liste halıne getırılır.


}
    }