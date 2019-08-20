package com.johnny.simulationexperimentservice.entity;

import lombok.Data;

@Data
public class KnowledgeEntity extends BaseEntity {
    private int knowledgeID;
    private String knowledgeName;
    private int systemID;
    private String systemName;
    private String knowledgeContent;
}
