package com.johnny.simulationexperimentservice.vo;

import lombok.Data;

@Data
public class KnowledgeVO extends BaseVO {
    private int knowledgeID;
    private String knowledgeName;
    private int systemID;
    private String systemName;
    private String knowledgeContent;
}
