package com.example.recipe.cooker.Controller;


import com.example.recipe.cooker.CookerAppService;
import com.example.recipe.cooker.dto.MealDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dev/api")
public class CookerAppController {
    private final CookerAppService m_cookerAppService;


    public CookerAppController(CookerAppService m_cookerAppService)
    {
        this.m_cookerAppService = m_cookerAppService;

    }
    @GetMapping("/meal")
    public ResponseEntity<MealDto> getMeal(@RequestParam String meal)
    {
        var mealDto = m_cookerAppService.searchMealWithProvider(meal);

        if(mealDto == null) {
            return ResponseEntity.notFound().build();

    }
        return ResponseEntity.ok(mealDto);

    }

    @PostMapping("/meal/favorites")

    //	Şu an query param kullanılıyor ileride parametreler çoğalırsa DTO kullanılacak..
    public ResponseEntity<MealDto> addFavoriteMeal(
            @RequestParam String meal,
            @RequestParam String customerName,
            @RequestParam Boolean isFavorite)
    {
        var addMeal = m_cookerAppService.saveFavoriteMeal(meal, customerName, isFavorite);

        //Daha sonra  profesyonel hata handling eklenecek (Optional veya custom exception)..
        if(addMeal == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(addMeal);

    }

}

