package com.johnny.simulationexperimentservice.service;

import com.johnny.simulationexperimentservice.dto.ClassSchedule4TeacherDTO;
import com.johnny.simulationexperimentservice.entity.ClassSchedule4TeacherEntity;
import com.johnny.simulationexperimentservice.vo.ClassSchedule4TeacherVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;

public interface ClassSchedule4TeacherService extends BaseService<ClassSchedule4TeacherDTO, ClassSchedule4TeacherVO, ClassSchedule4TeacherEntity> {

    UnifiedResponse findListByContent(int systemID, int teacherID);
}
