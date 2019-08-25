package com.johnny.simulationexperimentservice.mapper;

import com.johnny.simulationexperimentservice.entity.ClassSchedule4TeacherEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassSchedule4TeacherMapper extends BaseMapper<ClassSchedule4TeacherEntity> {
    int searchTotalCountByContent(int systemID, int teacherID);

    int searchClassScheduleCountByContent(int systemID, int teacherID, int courseOrder, int day);

    List<ClassSchedule4TeacherEntity> searchListByContent(int systemID, int teacherID);

    List<ClassSchedule4TeacherEntity> searchClassScheduleList(int systemID);

    int deleteByContent(int systemID, int teacherID, int courseOrder);
}
