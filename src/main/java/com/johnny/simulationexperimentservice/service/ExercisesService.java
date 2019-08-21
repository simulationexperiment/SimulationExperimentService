package com.johnny.simulationexperimentservice.service;

import com.johnny.simulationexperimentservice.dto.ExercisesDTO;
import com.johnny.simulationexperimentservice.entity.ExercisesEntity;
import com.johnny.simulationexperimentservice.vo.ExercisesVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;

public interface ExercisesService extends BaseService<ExercisesDTO, ExercisesVO, ExercisesEntity> {
    UnifiedResponse findListByContent(int pageNumber, int pageSize, int systemID, int knowledgeID, int userID);
}
