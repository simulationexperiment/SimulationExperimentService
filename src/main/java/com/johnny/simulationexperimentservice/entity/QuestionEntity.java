package com.johnny.simulationexperimentservice.entity;

import lombok.Data;

@Data
public class QuestionEntity extends BaseEntity {
    private int questionID;
    private String question;
    private int questionUser;
}
