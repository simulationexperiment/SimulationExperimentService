package com.johnny.simulationexperimentservice.entity;

import lombok.Data;

@Data
public class AnswerEntity extends BaseEntity {
    private int answerID;
    private int questionID;
    private String answer;
    private int answerUser;
}
