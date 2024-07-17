package com.shin.chef.shet.service;

import com.shin.chef.shet.enums.TypeEnum;
import com.shin.chef.shet.model.Meal;
import com.shin.chef.shet.repository.MealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MealsService {

    @Autowired
    private MealsRepository mealsRepository; //always start with private unless you need it to be public

    private String addPrefix (String type, String name){
        return switch (TypeEnum.valueOf(type.toUpperCase())) {
            case BREAKFAST -> "BF-" + name.toUpperCase();
            case LUNCH -> "LN-" + name.toUpperCase();
            case DINNER -> "DN-" + name.toUpperCase();
        };
    }

    public ResponseEntity<Meal> saveMeal(Meal meal){
        meal.setFood(addPrefix(meal.getType(), meal.getFood()));
        mealsRepository.save(meal);
        meal.setFood(meal.getFood().substring(3));
        return new ResponseEntity<Meal>(meal, HttpStatus.CREATED);
    }

}
