package com.johnny.simulationexperimentservice.service.impl;

import com.johnny.simulationexperimentservice.common.ObjectConvertUtils;
import com.johnny.simulationexperimentservice.constant.ResponseDataConstant;
import com.johnny.simulationexperimentservice.dto.SystemDTO;
import com.johnny.simulationexperimentservice.entity.SystemEntity;
import com.johnny.simulationexperimentservice.manager.UnifiedResponseManager;
import com.johnny.simulationexperimentservice.mapper.SystemMapper;
import com.johnny.simulationexperimentservice.service.BaseService;
import com.johnny.simulationexperimentservice.vo.SystemVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SystemServiceImpl implements BaseService<SystemDTO, SystemVO, SystemEntity> {
    @Autowired
    private SystemMapper myMapper;

    private Logger logger = LogManager.getLogger(SystemServiceImpl.class);

    @Override
    public UnifiedResponse findList(int pageNumber, int pageSize) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<SystemVO> modelList = new ArrayList<>();

            int totalCount = myMapper.searchTotalCount();
            if(totalCount == 0){
                return UnifiedResponseManager.buildSearchSuccessResponse(ResponseDataConstant.NO_SEARCH_COUNT, ResponseDataConstant.NO_DATA);
            }

            List<SystemEntity> entityList =  myMapper.searchList(startIndex, pageSize);
            for (SystemEntity entity : entityList) {
                SystemVO model = new SystemVO();
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
    public UnifiedResponse add(SystemDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse change(SystemDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse delete(SystemDTO dto) {
        return null;
    }
}
