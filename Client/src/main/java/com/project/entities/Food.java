//package com.project.entities;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class Food {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int foodId;
//
//    private String name;
//
//    private int duration;
//
//    private int caloriesCount;
//
//    @ManyToMany(mappedBy = "foods", fetch = FetchType.EAGER)
//    private List<Diet> diets;
//}
