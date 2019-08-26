package com.johnny.simulationexperimentservice.vo;

import lombok.Data;

import java.util.List;

@Data
public class QAVO {
    private QuestionVO question;
    private List<AnswerVO> answerList;
}
