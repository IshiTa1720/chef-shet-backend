package com.shin.chef.shet.repository;

import com.shin.chef.shet.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealsRepository extends JpaRepository<Meal, String> {
    List<Meal> findByType (String type);
}
