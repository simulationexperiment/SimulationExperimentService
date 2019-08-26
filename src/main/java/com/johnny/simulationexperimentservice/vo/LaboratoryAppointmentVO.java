package com.johnny.simulationexperimentservice.vo;

import lombok.Data;

@Data
public class LaboratoryAppointmentVO extends BaseVO {
    private int appointmentID;
    private String laboratoryDate;
    private int courseOrder;
    private int laboratoryID;
    private String laboratoryName;
    private int appointmentUser;
}
