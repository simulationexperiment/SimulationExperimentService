package com.johnny.simulationexperimentservice.vo;

import lombok.Data;

@Data
public class ClassSchedule4TeacherVO extends BaseVO {
    private int scheduleID;
    private int systemID;
    private String systemName;
    private int teacherID;
    private String teacherName;
    private int courseOrder;
    private String mondayCourse;
    private String tuesdayCourse;
    private String wednesdayCourse;
    private String thursdayCourse;
    private String fridayCourse;
    private String saturdayCourse;
    private String sundayCourse;
}
