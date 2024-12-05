package com.red_montano.navidar.Kids.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "kids")
@Entity
@Data
public class Kid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private String name;
    private String lastName;
    private Integer age;
    private String ageGroup;
    private String gender;
    private String parent;
    private Integer page;
    private String assistance = "NO";
    private String gift = "NO";
}
