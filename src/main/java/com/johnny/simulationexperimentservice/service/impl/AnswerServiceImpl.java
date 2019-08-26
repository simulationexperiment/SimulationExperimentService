package com.johnny.simulationexperimentservice.service.impl;

import com.johnny.simulationexperimentservice.common.ObjectConvertUtils;
import com.johnny.simulationexperimentservice.constant.ResponseDataConstant;
import com.johnny.simulationexperimentservice.dto.AnswerDTO;
import com.johnny.simulationexperimentservice.entity.AnswerEntity;
import com.johnny.simulationexperimentservice.manager.UnifiedResponseManager;
import com.johnny.simulationexperimentservice.mapper.AnswerMapper;
import com.johnny.simulationexperimentservice.service.AnswerService;
import com.johnny.simulationexperimentservice.vo.AnswerVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerMapper myMapper;

    private Logger logger = LogManager.getLogger(AnswerServiceImpl.class);
    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize, int questionID) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<AnswerVO> modelList = new ArrayList<>();
            int totalCount = myMapper.searchTotalCountByContent(questionID);
            if(totalCount == 0){
                return UnifiedResponseManager.buildSearchSuccessResponse(ResponseDataConstant.NO_SEARCH_COUNT, ResponseDataConstant.NO_DATA);
            }
            List<AnswerEntity> entityList =  myMapper.searchListByContent(startIndex, pageSize, questionID);
            for (AnswerEntity entity : entityList) {
                AnswerVO model = new AnswerVO();
                ObjectConvertUtils.toBean(entity, model);
                modelList.add(model);
            }
            return UnifiedResponseManager.buildSearchSuccessResponse(totalCount, modelList);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildExceptionResponse();
        }
    }

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
    public UnifiedResponse add(AnswerDTO dto) {
        try {
            AnswerEntity entity = new AnswerEntity();
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
    public UnifiedResponse change(AnswerDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse delete(int id) {
        try {
            int affectRow = myMapper.delete(id);
            return UnifiedResponseManager.buildSubmitSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildExceptionResponse();
        }
    }
}
