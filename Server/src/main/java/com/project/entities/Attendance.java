package com.project.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendanceId;

    private Date lastLogin;

    private int attendance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId", referencedColumnName = "clientId")
//    @OneToOne(mappedBy = "attendanceDate", cascade = CascadeType.ALL)
    private Client client;
}
