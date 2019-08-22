package com.johnny.simulationexperimentservice.dto;

import lombok.Data;

@Data
public class TeachingResourceDTO extends BaseDTO {
    private int resourceID;
    private int systemID;
    private int courseID;
    private int resourceTypeID;
    private String resourceUri;
    private int auditorID;
    private String resourceStatus;
}
