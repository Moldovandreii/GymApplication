package com.project.dao;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodDAO implements Serializable {
    private int foodId;
    private String name;
    private int duration;
    private int caloriesCount;
}
