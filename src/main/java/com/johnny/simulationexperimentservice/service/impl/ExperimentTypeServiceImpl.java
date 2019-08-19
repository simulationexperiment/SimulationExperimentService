package com.johnny.simulationexperimentservice.service.impl;

import com.johnny.simulationexperimentservice.common.ObjectConvertUtils;
import com.johnny.simulationexperimentservice.constant.ResponseDataConstant;
import com.johnny.simulationexperimentservice.dto.ExperimentTypeDTO;
import com.johnny.simulationexperimentservice.entity.ExperimentTypeEntity;
import com.johnny.simulationexperimentservice.manager.UnifiedResponseManager;
import com.johnny.simulationexperimentservice.mapper.ExperimentTypeMapper;
import com.johnny.simulationexperimentservice.service.BaseService;
import com.johnny.simulationexperimentservice.vo.ExperimentTypeVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperimentTypeServiceImpl implements BaseService<ExperimentTypeDTO, ExperimentTypeVO, ExperimentTypeEntity> {
    @Autowired
    private ExperimentTypeMapper myMapper;

    private Logger logger = LogManager.getLogger(ExperimentTypeServiceImpl.class);

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<ExperimentTypeVO> modelList = new ArrayList<>();

            int totalCount = myMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSearchSuccessResponse(ResponseDataConstant.NO_SEARCH_COUNT, ResponseDataConstant.NO_DATA);
            }

            List<ExperimentTypeEntity> entityList =  myMapper.searchList(startIndex, pageSize);
            for (ExperimentTypeEntity entity : entityList) {
                ExperimentTypeVO model = new ExperimentTypeVO();
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
    public UnifiedResponse find(int id) {
        return null;
    }

    @Override
    public UnifiedResponse existCheck(String value) {
        return null;
    }

    @Override
    public UnifiedResponse add(ExperimentTypeDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse change(ExperimentTypeDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse delete(ExperimentTypeDTO dto) {
        return null;
    }
}
