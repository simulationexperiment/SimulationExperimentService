package com.johnny.simulationexperimentservice.dto;

import lombok.Data;

@Data
public class QuestionDTO extends BaseDTO {
    private int questionID;
    private String question;
}
