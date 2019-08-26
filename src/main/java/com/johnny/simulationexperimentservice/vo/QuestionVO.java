package com.johnny.simulationexperimentservice.vo;

import lombok.Data;

@Data
public class QuestionVO extends BaseVO {
    private int questionID;
    private String question;
    private int questionUser;
}
