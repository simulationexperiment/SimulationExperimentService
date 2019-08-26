package com.johnny.simulationexperimentservice.dto;

import lombok.Data;

@Data
public class AnswerDTO extends BaseDTO {
    private int answerID;
    private int questionID;
    private String answer;
}
