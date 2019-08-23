package com.johnny.simulationexperimentservice.dto;

import lombok.Data;

@Data
public class ExperimentDTO extends BaseDTO {
    private int experimentID;
    private int systemID;
    private int courseID;
    private int experimentTypeID;
    private String experimentName;
    private String experimentContent;
}
