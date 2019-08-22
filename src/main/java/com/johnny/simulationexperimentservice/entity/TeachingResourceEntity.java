package com.johnny.simulationexperimentservice.entity;

import lombok.Data;

@Data
public class TeachingResourceEntity extends BaseEntity {
    private int resourceID;
    private int systemID;
    private String systemName;
    private int courseID;
    private String courseName;
    private int resourceTypeID;
    private String resourceTypeName;
    private String resourceName;
    private String resourceUri;
    private int auditorID;
    private String auditorName;
    private String resourceStatus;
    private String resourceStatusText;
}
