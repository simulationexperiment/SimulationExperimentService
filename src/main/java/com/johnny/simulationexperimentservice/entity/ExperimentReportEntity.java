package com.johnny.simulationexperimentservice.entity;

import lombok.Data;

@Data
public class ExperimentReportEntity extends BaseEntity {
    private int reportID;
    private int systemID;
    private String systemName;
    private int courseID;
    private String courseName;
    private int experimentTypeID;
    private String experimentTypeName;
    private int experimentID;
    private String experimentName;
    private String startTime;
    private String endTime;
    private String reportUri;
    private String reportName;
    private String reportStatus;
    private String reportStatusText;
    private int correctorID;
    private String correctorName;
    private float disciplineScore;
    private float practiceScore;
    private float reportScore;
    private float totalScore;
}
