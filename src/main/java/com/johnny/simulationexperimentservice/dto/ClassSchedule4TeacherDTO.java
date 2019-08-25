package com.johnny.simulationexperimentservice.dto;

import lombok.Data;

@Data
public class ClassSchedule4TeacherDTO extends BaseDTO {
    private int scheduleID;
    private int systemID;
    private int teacherID;
    private int courseOrder;
    private String mondayCourse;
    private String tuesdayCourse;
    private String wednesdayCourse;
    private String thursdayCourse;
    private String fridayCourse;
    private String saturdayCourse;
    private String sundayCourse;
}
