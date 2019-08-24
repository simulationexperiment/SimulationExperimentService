package com.johnny.simulationexperimentservice.dto;

import lombok.Data;

@Data
public class ExperimentReportDTO extends BaseDTO {
    private int reportID;
    private int systemID;
    private int courseID;
    private int experimentTypeID;
    private int experimentID;
    private String startTime;
    private String endTime;
    private String reportUri;
    private String reportStatus;
    private int correctorID;
    private float disciplineScore;
    private float practiceScore;
    private float reportScore;
}
