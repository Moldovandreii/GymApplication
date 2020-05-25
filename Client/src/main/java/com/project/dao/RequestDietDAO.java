package com.project.dao;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class RequestDietDAO implements Serializable {
    private int requestDietId;
    private int clientId;
    private int trainerId;
    private String request;
}
