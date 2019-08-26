package com.johnny.simulationexperimentservice.dto;

import lombok.Data;

@Data
public class LaboratoryAppointmentDTO extends BaseDTO {
    private int appointmentID;
    private String laboratoryDate;
    private int courseOrder;
    private int laboratoryID;
}
