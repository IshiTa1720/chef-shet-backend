package com.shin.chef.shet.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Entity
@Table(name = "Meals")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Meals {
    @Id
    @Column(name = "Food")
    String food;

    @Column(name = "Type")
    String type;

    @Column(name = "Estimated Time Needed (min)")
    int estTime;
}
