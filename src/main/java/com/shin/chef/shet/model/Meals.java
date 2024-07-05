package com.shin.chef.shet.model;

 import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.boot.autoconfigure.web.WebProperties;

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
