package com.project.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class RequestDiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestDietId;

    private int clientId;

    private int trainerId;

    private String request;

    private String status;
}
