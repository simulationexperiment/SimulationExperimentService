package com.johnny.simulationexperimentservice.service;

import com.johnny.simulationexperimentservice.dto.ExperimentDTO;
import com.johnny.simulationexperimentservice.entity.ExperimentEntity;
import com.johnny.simulationexperimentservice.vo.ExperimentVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;

public interface ExperimentService extends BaseService<ExperimentDTO, ExperimentVO, ExperimentEntity> {
    UnifiedResponse findListByContent(int pageNumber, int pageSize, int systemID, int courseID, int experimentTypeID);
}
