package com.project.dao;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDAO implements Serializable {
    private int activityId;
    private String name;
    private int duration;
    private int intensity;
}
