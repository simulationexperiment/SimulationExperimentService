package com.johnny.simulationexperimentservice.vo;

import lombok.Data;

@Data
public class AnswerVO extends BaseVO {
    private int answerID;
    private int questionID;
    private String answer;
    private int answerUser;
}
