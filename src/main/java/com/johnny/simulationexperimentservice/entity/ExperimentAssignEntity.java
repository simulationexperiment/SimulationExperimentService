package com.johnny.simulationexperimentservice.entity;

import lombok.Data;

@Data
public class ExperimentAssignEntity extends BaseEntity {
    private int experimentAssignID;
    private int systemID;
    private String systemName;
    private int courseID;
    private String courseName;
    private int experimentTypeID;
    private String experimentTypeName;
    private int experimentID;
    private String experimentName;
    private int experimentTimes;
}
