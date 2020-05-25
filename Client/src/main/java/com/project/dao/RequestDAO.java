package com.project.dao;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDAO implements Serializable {
    private int requestId;
    private int clientId;
    private int fromTrainer;
    private String fromTrainerResponse;
    private int toTrainer;
    private String toTrainerResponse;
    private String requestResponse;
}
