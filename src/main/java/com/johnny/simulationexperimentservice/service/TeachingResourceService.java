package com.johnny.simulationexperimentservice.service;

import com.johnny.simulationexperimentservice.dto.TeachingResourceDTO;
import com.johnny.simulationexperimentservice.entity.TeachingResourceEntity;
import com.johnny.simulationexperimentservice.vo.TeachingResourceVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;

public interface TeachingResourceService extends BaseService<TeachingResourceDTO, TeachingResourceVO, TeachingResourceEntity> {
    UnifiedResponse findListByContent(int pageNumber, int pageSize, int systemID, int courseID, int resourceTypeID);

    UnifiedResponse changeStatus(TeachingResourceDTO dto);
}
