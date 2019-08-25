package com.johnny.simulationexperimentservice.vo;

import lombok.Data;

@Data
public class ExperimentAssignVO extends BaseVO {
    private int experimentAssignID;
    private int systemID;
    private String systemName;
    private int courseID;
    private String courseName;
    private int experimentTypeID;
    private String experimentTypeName;
    private int experimentID;
    private String experimentName;
    private String experimentContent;
    private int experimentTimes;
}
