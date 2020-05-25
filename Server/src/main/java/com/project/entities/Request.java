package com.project.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter

public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    private int clientId;

    private int fromTrainer;

    private String fromTrainerResponse;

    private int toTrainer;

    private String toTrainerResponse;

    private String requestResponse;
}
