package com.shin.chef.shet.controller;

import com.shin.chef.shet.model.Meal;
import com.shin.chef.shet.model.MealResponse;
import com.shin.chef.shet.service.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/meal")
public class MealsController {

    @Autowired //@Autowired is used for dependency injection
    private MealsService mealsService;

    @PostMapping
    public ResponseEntity<Meal> saveMeal(@RequestBody Meal meal) {
        return mealsService.saveMeal(meal);
    }

    @GetMapping
    public ResponseEntity<MealResponse> readRandomMeal(@RequestParam String type) {
        return mealsService.randomMeal(type);
    }
}
