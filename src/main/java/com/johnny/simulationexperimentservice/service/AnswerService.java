package com.johnny.simulationexperimentservice.service;

import com.johnny.simulationexperimentservice.dto.AnswerDTO;
import com.johnny.simulationexperimentservice.entity.AnswerEntity;
import com.johnny.simulationexperimentservice.vo.AnswerVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;

public interface AnswerService extends BaseService<AnswerDTO, AnswerVO, AnswerEntity> {
    UnifiedResponse findList(int pageNumber, int pageSize, int questionID);
}
