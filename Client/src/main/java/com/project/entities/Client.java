//package com.project.entities;
//
//import lombok.*;
//
//import javax.persistence.*;
//
//@Entity
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class Client {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int clientId;
//
//    private String name;
//
//    private String password;
//
////    private int attendance;
//
//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
//    @JoinColumn(name = "trainerId", nullable = false)
//    private Trainer trainer;
//
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "client")
//    private Attendance attendanceDate;
//}
