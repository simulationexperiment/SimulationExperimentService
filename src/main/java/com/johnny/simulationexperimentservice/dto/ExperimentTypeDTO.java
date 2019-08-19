package com.johnny.simulationexperimentservice.dto;

import lombok.Data;

@Data
public class ExperimentTypeDTO extends BaseDTO {
    private int experimentTypeID;
    private String experimentTypeName;
}
