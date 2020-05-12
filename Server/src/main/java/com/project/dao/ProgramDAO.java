package com.project.dao;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramDAO implements Serializable {
    private int programId;
    private String name;
    private int trainerID;
}
