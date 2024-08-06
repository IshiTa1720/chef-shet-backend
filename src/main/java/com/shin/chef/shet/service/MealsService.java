package com.shin.chef.shet.service;

import com.shin.chef.shet.enums.TypeEnum;
import com.shin.chef.shet.model.Meal;
import com.shin.chef.shet.model.MealResponse;
import com.shin.chef.shet.repository.MealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealsService {

    @Autowired
    private MealsRepository mealsRepository; //always start with private unless you need it to be public

    private String addPrefix (String type, String name){
        return switch (TypeEnum.valueOf(type.toUpperCase())) { //TypeEnum is an enum we created with the types of meals
            case BREAKFAST -> "BF-" + name.toUpperCase();
            case LUNCH -> "LN-" + name.toUpperCase();
            case DINNER -> "DN-" + name.toUpperCase();
        };
    }

    public ResponseEntity<Meal> saveMeal(Meal meal){
        meal.setFood(addPrefix(meal.getType(), meal.getFood())); //setting the food name with a prefix
        meal.setType(meal.getType().toUpperCase()); //setting the type of  food in uppercase
        mealsRepository.save(meal);
        meal.setFood(meal.getFood().substring(3));
        return new ResponseEntity<Meal>(meal, HttpStatus.CREATED);
    }

    public ResponseEntity<MealResponse> randomMeal (String type){
        MealResponse mealResponse = new MealResponse();
        List<Meal> mealList = mealsRepository.findByType(type.toUpperCase());
        Meal testMeal = mealList.get(0);
        mealResponse.setFuud(testMeal.getFood().substring(3));
        mealResponse.setEstimatedTime(testMeal.getEstTime());
        return new ResponseEntity<MealResponse>(mealResponse, HttpStatus.OK);
    }
}
