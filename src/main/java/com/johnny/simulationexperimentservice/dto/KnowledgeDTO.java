package com.johnny.simulationexperimentservice.dto;

import lombok.Data;

@Data
public class KnowledgeDTO extends BaseDTO {
    private int knowledgeID;
    private String knowledgeName;
    private int systemID;
    private String knowledgeContent;
}
