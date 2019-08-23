package com.johnny.simulationexperimentservice.service;

import com.johnny.simulationexperimentservice.dto.ExperimentAssignDTO;
import com.johnny.simulationexperimentservice.entity.ExperimentAssignEntity;
import com.johnny.simulationexperimentservice.vo.ExperimentAssignVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;

public interface ExperimentAssignService extends BaseService<ExperimentAssignDTO, ExperimentAssignVO, ExperimentAssignEntity> {
    UnifiedResponse findListByContent(int pageNumber, int pageSize, int systemID, int courseID, int experimentTypeID);
}
