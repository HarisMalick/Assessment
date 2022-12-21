package com.lendo.assessment.LendoAssmt.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {

    private String message;
    private String status;
    private Object data;
}
