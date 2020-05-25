package com.project.dao;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainerDAO implements Serializable {
    private int trainerId;
    private String username;
    private String password;
    private String mail;
    private float review;
    private int reviews;
}
