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
//public class Activity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int activityId;
//
//    private String name;
//
//    private int duration;
//
//    private int intensity;
//
//    @ManyToMany(mappedBy = "activities", fetch = FetchType.EAGER)
//    private List<Program> programs;
//
//    @Override
//    public String toString(){
//        return this.name;
//    }
//}
