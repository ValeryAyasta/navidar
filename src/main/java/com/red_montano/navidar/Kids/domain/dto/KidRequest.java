package com.red_montano.navidar.Kids.domain.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class KidRequest {
    private String name;
    private String lastName;
    private Integer age;
    private String gender;
    private String parent;
    private String assistance;
}