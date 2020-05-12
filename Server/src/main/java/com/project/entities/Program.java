package com.project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int programId;

    private String programName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "trainerId", nullable = false)
    private Trainer trainer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "aux_program_activities",
            joinColumns = @JoinColumn(name = "programId"),
            inverseJoinColumns = @JoinColumn(name = "activityId"))
    private List<Activity> activities;

    @Override
    public String toString(){
        return this.programName;
    }
}
