package com.project.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Diet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int dietId;

    private String dietName;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "trainerId", nullable = false)
    private Trainer trainer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "aux_diet_food",
            joinColumns = @JoinColumn(name = "dietId"),
            inverseJoinColumns = @JoinColumn(name = "foodId"))
    private List<Food> foods;

    @OneToMany(mappedBy = "diet", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Client> clients;
}
