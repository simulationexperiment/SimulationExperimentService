package com.johnny.simulationexperimentservice.service;

import com.johnny.simulationexperimentservice.dto.LaboratoryAppointmentDTO;
import com.johnny.simulationexperimentservice.entity.LaboratoryAppointmentEntity;
import com.johnny.simulationexperimentservice.vo.LaboratoryAppointmentVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;

public interface LaboratoryAppointmentService extends BaseService<LaboratoryAppointmentDTO, LaboratoryAppointmentVO, LaboratoryAppointmentEntity>{

    UnifiedResponse findScheduledCountByContent(String laboratoryDate, int courseOrder, int laboratoryID);

    UnifiedResponse findListByContent(int pageNumber, int pageSize, String fromDate, String toDate);
}
