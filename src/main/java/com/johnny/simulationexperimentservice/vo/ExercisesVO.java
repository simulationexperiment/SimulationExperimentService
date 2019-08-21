package com.johnny.simulationexperimentservice.vo;

import lombok.Data;

@Data
public class ExercisesVO extends BaseVO {
    private int exercisesID;
    private int systemID;
    private String systemName;
    private int courseID;
    private String courseName;
    private int knowledgeID;
    private String knowledgeName;
    private int exercisesTypeID;
    private String exercisesTypeName;
    private int experimentTypeID;
    private String experimentTypeName;
    private String exercisesContent;
}
