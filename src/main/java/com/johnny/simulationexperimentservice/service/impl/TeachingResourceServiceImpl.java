package com.johnny.simulationexperimentservice.service.impl;

import com.johnny.simulationexperimentservice.common.ObjectConvertUtils;
import com.johnny.simulationexperimentservice.constant.ResponseDataConstant;
import com.johnny.simulationexperimentservice.constant.TeachingResourceStatusConstant;
import com.johnny.simulationexperimentservice.dto.TeachingResourceDTO;
import com.johnny.simulationexperimentservice.entity.TeachingResourceEntity;
import com.johnny.simulationexperimentservice.manager.UnifiedResponseManager;
import com.johnny.simulationexperimentservice.mapper.TeachingResourceMapper;
import com.johnny.simulationexperimentservice.service.TeachingResourceService;
import com.johnny.simulationexperimentservice.vo.TeachingResourceVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeachingResourceServiceImpl implements TeachingResourceService {
    @Autowired
    private TeachingResourceMapper myMapper;

    private Logger logger = LogManager.getLogger(TeachingResourceServiceImpl.class);

    @Override
    public UnifiedResponse findListByContent(int pageNumber, int pageSize, int systemID, int courseID, int resourceTypeID, String resourceStatus, int auditorID) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            List<TeachingResourceVO> modelList = new ArrayList<>();
            if(auditorID == 0 || auditorID == 1){
                auditorID = 0;
            }
            int totalCount = myMapper.searchTotalCountByContent(systemID, courseID, resourceTypeID, resourceStatus.equals("null") ? null : resourceStatus, auditorID);
            if(totalCount == 0){
                return UnifiedResponseManager.buildSearchSuccessResponse(ResponseDataConstant.NO_SEARCH_COUNT, ResponseDataConstant.NO_DATA);
            }

            List<TeachingResourceEntity> entityList =  myMapper.searchListByContent(startIndex, pageSize, systemID, courseID, resourceTypeID, resourceStatus.equals("null") ? null : resourceStatus, auditorID);
            for (TeachingResourceEntity entity : entityList) {
                TeachingResourceVO model = new TeachingResourceVO();
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
    public UnifiedResponse changeStatus(TeachingResourceDTO dto) {
        try {
            TeachingResourceEntity entity = new TeachingResourceEntity();
            ObjectConvertUtils.toBean(dto, entity);
            entity.setUpdateUser(dto.getLoginUser());
            int affectRow = myMapper.changeStatus(entity);
            return UnifiedResponseManager.buildSubmitSuccessResponse(affectRow);
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
        try {
            TeachingResourceEntity entity =  myMapper.searchByID(id);
            if(entity == null){
                return UnifiedResponseManager.buildSearchSuccessResponse(ResponseDataConstant.NO_SEARCH_COUNT, ResponseDataConstant.NO_DATA);
            }
            TeachingResourceVO model = new TeachingResourceVO();
            ObjectConvertUtils.toBean(entity, model);
            return UnifiedResponseManager.buildSearchSuccessResponse(ResponseDataConstant.ONE_SEARCH_COUNT, model);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildExceptionResponse();
        }
    }

    @Override
    public UnifiedResponse existCheck(String value) {
        return null;
    }

    @Override
    public UnifiedResponse add(TeachingResourceDTO dto) {
        try {
            TeachingResourceEntity entity = new TeachingResourceEntity();
            ObjectConvertUtils.toBean(dto, entity);
            entity.setResourceStatus(TeachingResourceStatusConstant.PENDING);
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
    public UnifiedResponse change(TeachingResourceDTO dto) {
        try {
            TeachingResourceEntity entity = new TeachingResourceEntity();
            ObjectConvertUtils.toBean(dto, entity);
            entity.setUpdateUser(dto.getLoginUser());
            int affectRow = myMapper.update(entity);
            return UnifiedResponseManager.buildSubmitSuccessResponse(affectRow);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildExceptionResponse();
        }
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
