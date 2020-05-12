package com.project.dao;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DietDAO implements Serializable {
    private int dietId;
    private String dietName;
    private int trainerId;
}
