package com.shin.chef.shet.model;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;


@Entity
@Table(name = "Meals")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal {
    @Id
    @Column(name = "Food")
    private String food;

    @Column(name = "Type")
    private String type;

    @Column(name = "Estimated Time Needed (min)")
    private int estTime;
}
