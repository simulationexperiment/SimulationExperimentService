package com.johnny.simulationexperimentservice.service.impl;

import com.johnny.simulationexperimentservice.common.ObjectConvertUtils;
import com.johnny.simulationexperimentservice.dto.QuestionDTO;
import com.johnny.simulationexperimentservice.entity.QuestionEntity;
import com.johnny.simulationexperimentservice.manager.UnifiedResponseManager;
import com.johnny.simulationexperimentservice.mapper.AnswerMapper;
import com.johnny.simulationexperimentservice.mapper.QuestionMapper;
import com.johnny.simulationexperimentservice.service.BaseService;
import com.johnny.simulationexperimentservice.vo.QuestionVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements BaseService<QuestionDTO, QuestionVO, QuestionEntity> {

    @Autowired
    private QuestionMapper myMapper;

    @Autowired
    private AnswerMapper answerMapper;

    private Logger logger = LogManager.getLogger(QuestionServiceImpl.class);

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UnifiedResponse find(int id) {
        return null;
    }

    @Override
    public UnifiedResponse existCheck(String value) {
        return null;
    }

    @Override
    public UnifiedResponse add(QuestionDTO dto) {
        try {
            QuestionEntity entity = new QuestionEntity();
            ObjectConvertUtils.toBean(dto, entity);
            entity.setCreateUser(dto.getLoginUser());
            entity.setUpdateUser(dto.getLoginUser());
            int affectRow = myMapper.insert(entity);
            return UnifiedResponseManager.buildSubmitSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildExceptionResponse();
        }
    }

    @Override
    public UnifiedResponse change(QuestionDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse delete(int id) {
        try {
            int affectRow = myMapper.delete(id);
            affectRow += answerMapper.deleteByQuestion(id);
            return UnifiedResponseManager.buildSubmitSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildExceptionResponse();
        }
    }
}
