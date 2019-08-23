package com.johnny.simulationexperimentservice.entity;

import lombok.Data;

@Data
public class ExperimentEntity extends BaseEntity {
    private int experimentID;
    private int systemID;
    private String systemName;
    private int courseID;
    private String courseName;
    private int experimentTypeID;
    private String experimentTypeName;
    private String experimentName;
    private String experimentContent;
}
