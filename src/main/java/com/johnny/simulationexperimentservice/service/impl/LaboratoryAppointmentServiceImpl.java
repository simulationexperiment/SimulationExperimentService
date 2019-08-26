package com.johnny.simulationexperimentservice.service.impl;

import com.johnny.simulationexperimentservice.common.ObjectConvertUtils;
import com.johnny.simulationexperimentservice.constant.ResponseDataConstant;
import com.johnny.simulationexperimentservice.dto.LaboratoryAppointmentDTO;
import com.johnny.simulationexperimentservice.entity.LaboratoryAppointmentEntity;
import com.johnny.simulationexperimentservice.manager.UnifiedResponseManager;
import com.johnny.simulationexperimentservice.mapper.LaboratoryAppointmentMapper;
import com.johnny.simulationexperimentservice.service.LaboratoryAppointmentService;
import com.johnny.simulationexperimentservice.vo.LaboratoryAppointmentVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LaboratoryAppointmentServiceImpl implements LaboratoryAppointmentService {
    @Autowired
    private LaboratoryAppointmentMapper myMapper;

    private Logger logger = LogManager.getLogger(LaboratoryAppointmentServiceImpl.class);

    @Override
    public UnifiedResponse findScheduledCountByContent(String laboratoryDate, int courseOrder, int laboratoryID) {
        try{
            int count = myMapper.searchScheduledCountByContent(laboratoryDate, courseOrder, laboratoryID);
            if(count == 0){
                return UnifiedResponseManager.buildSearchSuccessResponse(ResponseDataConstant.NO_SEARCH_COUNT, false);
            }
            return UnifiedResponseManager.buildSearchSuccessResponse(count, true);
        } catch (Exception ex) {
            logger.error(ex.toString());
            return UnifiedResponseManager.buildExceptionResponse();
        }
    }

    @Override
    public UnifiedResponse findListByContent(int pageNumber, int pageSize, String fromDate, String toDate) {
        try {
            int startIndex = (pageNumber - 1) * pageSize;
            fromDate = fromDate + " 00:00:00";
            toDate = toDate + " 23:59:59";
            List<LaboratoryAppointmentVO> modelList = new ArrayList<>();
            int totalCount = myMapper.searchTotalCountByContent(fromDate, toDate);
            if(totalCount == 0){
                return UnifiedResponseManager.buildSearchSuccessResponse(ResponseDataConstant.NO_SEARCH_COUNT, ResponseDataConstant.NO_DATA);
            }
            List<LaboratoryAppointmentEntity> entityList =  myMapper.searchListByContent(startIndex, pageSize, fromDate, toDate);
            for (LaboratoryAppointmentEntity entity : entityList) {
                LaboratoryAppointmentVO model = new LaboratoryAppointmentVO();
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
    public UnifiedResponse add(LaboratoryAppointmentDTO dto) {
        try {
            LaboratoryAppointmentEntity entity = new LaboratoryAppointmentEntity();
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
    public UnifiedResponse change(LaboratoryAppointmentDTO dto) {
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
