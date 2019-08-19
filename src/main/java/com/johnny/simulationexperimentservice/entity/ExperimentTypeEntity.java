package com.johnny.simulationexperimentservice.entity;

import lombok.Data;

@Data
public class ExperimentTypeEntity extends BaseEntity {
    private int experimentTypeID;
    private String experimentTypeName;
}
