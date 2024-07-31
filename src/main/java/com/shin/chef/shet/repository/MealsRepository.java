package com.shin.chef.shet.repository;

import com.shin.chef.shet.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealsRepository extends JpaRepository<Meal, String> {
}
