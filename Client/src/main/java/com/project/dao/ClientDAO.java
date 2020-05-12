package com.project.dao;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientDAO implements Serializable {
    private int clientId;
    private String name;
    private String password;
}
