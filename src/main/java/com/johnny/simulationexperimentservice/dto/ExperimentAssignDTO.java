package com.johnny.simulationexperimentservice.dto;

import lombok.Data;

@Data
public class ExperimentAssignDTO extends BaseDTO {
    private int experimentAssignID;
    private int systemID;
    private int courseID;
    private int experimentTypeID;
    private int experimentID;
    private int experimentTimes;
}
