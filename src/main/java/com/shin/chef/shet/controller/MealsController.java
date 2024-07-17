package com.shin.chef.shet.controller;

import com.shin.chef.shet.model.Meal;
import com.shin.chef.shet.service.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meal")
public class MealsController {

    @Autowired
    private MealsService mealsService;

    @PostMapping
    public ResponseEntity<Meal> saveMeal(@RequestBody Meal meal) {
        return mealsService.saveMeal(meal);
    }
}
