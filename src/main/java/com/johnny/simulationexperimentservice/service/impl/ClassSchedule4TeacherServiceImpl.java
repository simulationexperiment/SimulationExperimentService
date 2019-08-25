package com.johnny.simulationexperimentservice.service.impl;

import com.johnny.simulationexperimentservice.common.ObjectConvertUtils;
import com.johnny.simulationexperimentservice.constant.ResponseDataConstant;
import com.johnny.simulationexperimentservice.dto.ClassSchedule4TeacherDTO;
import com.johnny.simulationexperimentservice.entity.ClassSchedule4TeacherEntity;
import com.johnny.simulationexperimentservice.manager.UnifiedResponseManager;
import com.johnny.simulationexperimentservice.mapper.ClassSchedule4TeacherMapper;
import com.johnny.simulationexperimentservice.service.ClassSchedule4TeacherService;
import com.johnny.simulationexperimentservice.vo.ClassSchedule4TeacherVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassSchedule4TeacherServiceImpl implements ClassSchedule4TeacherService {
    @Autowired
    private ClassSchedule4TeacherMapper myMapper;

    private Logger logger = LogManager.getLogger(ClassSchedule4TeacherServiceImpl.class);

    @Override
    public UnifiedResponse findListByContent(int systemID, int teacherID) {
        try {
            List<ClassSchedule4TeacherVO> modelList = new ArrayList<>();
            int totalCount = myMapper.searchTotalCountByContent(systemID, teacherID);
            if(totalCount == 0){
                return UnifiedResponseManager.buildSearchSuccessResponse(ResponseDataConstant.NO_SEARCH_COUNT, ResponseDataConstant.NO_DATA);
            }
            List<ClassSchedule4TeacherEntity> entityList =  myMapper.searchListByContent(systemID, teacherID);
            for (ClassSchedule4TeacherEntity entity : entityList) {
                ClassSchedule4TeacherVO model = new ClassSchedule4TeacherVO();
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
        try {
            ClassSchedule4TeacherEntity entity =  myMapper.searchByID(id);
            if(entity == null){
                return UnifiedResponseManager.buildSearchSuccessResponse(ResponseDataConstant.NO_SEARCH_COUNT, ResponseDataConstant.NO_DATA);
            }
            ClassSchedule4TeacherVO model = new ClassSchedule4TeacherVO();
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
    public UnifiedResponse add(ClassSchedule4TeacherDTO dto) {
        try {
            ClassSchedule4TeacherEntity entity = new ClassSchedule4TeacherEntity();
            myMapper.deleteByContent(dto.getSystemID(), dto.getTeacherID(), dto.getCourseOrder());

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
    public UnifiedResponse change(ClassSchedule4TeacherDTO dto) {
        return null;
    }

    @Override
    public UnifiedResponse delete(int id) {
        return null;
    }
}
