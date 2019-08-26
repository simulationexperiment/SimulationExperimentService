package com.johnny.simulationexperimentservice.entity;

import lombok.Data;

@Data
public class LaboratoryAppointmentEntity extends BaseEntity {
    private int appointmentID;
    private String laboratoryDate;
    private int courseOrder;
    private int laboratoryID;
    private String laboratoryName;
    private int appointmentUser;
}
