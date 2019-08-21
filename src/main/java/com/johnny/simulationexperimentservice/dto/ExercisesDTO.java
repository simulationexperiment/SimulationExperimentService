package com.johnny.simulationexperimentservice.dto;

import lombok.Data;

@Data
public class ExercisesDTO extends BaseDTO{
    private int exercisesID;
    private int systemID;
    private String systemName;
    private int exercisesTypeID;
    private String exercisesTypeName;
    private int courseID;
    private String courseName;
    private int knowledgeID;
    private String knowledgeName;
    private int experimentTypeID;
    private String experimentTypeName;
    private String exercisesContent;
}
