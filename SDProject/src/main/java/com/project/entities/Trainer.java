package com.project.entities;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainerId;

    private String username;

    private String password;

    private String mail;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Program> programs;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Client> clients;

    @Override
    public String toString(){
        return this.username;
    }
}