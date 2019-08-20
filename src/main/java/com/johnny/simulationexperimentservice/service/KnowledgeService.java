package com.johnny.simulationexperimentservice.service;

import com.johnny.simulationexperimentservice.dto.KnowledgeDTO;
import com.johnny.simulationexperimentservice.entity.KnowledgeEntity;
import com.johnny.simulationexperimentservice.vo.KnowledgeVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;

public interface KnowledgeService extends BaseService<KnowledgeDTO, KnowledgeVO, KnowledgeEntity> {
    UnifiedResponse findListByContent(int pageNumber, int pageSize, int systemID, int userID);
}
