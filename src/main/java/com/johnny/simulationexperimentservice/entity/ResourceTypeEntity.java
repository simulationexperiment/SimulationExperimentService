package com.johnny.simulationexperimentservice.entity;

import lombok.Data;

@Data
public class ResourceTypeEntity extends BaseEntity {
    private int sourceTypeID;
    private String sourceTypeName;
}
