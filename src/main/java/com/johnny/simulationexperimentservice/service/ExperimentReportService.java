package com.johnny.simulationexperimentservice.service;

import com.johnny.simulationexperimentservice.dto.ExperimentReportDTO;
import com.johnny.simulationexperimentservice.entity.ExperimentReportEntity;
import com.johnny.simulationexperimentservice.vo.ExperimentReportVO;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;

public interface ExperimentReportService extends BaseService<ExperimentReportDTO, ExperimentReportVO, ExperimentReportEntity> {
    UnifiedResponse findListByContent(int pageNumber,
                                      int pageSize,
                                      int systemID,
                                      int courseID,
                                      int experimentTypeID,
                                      String reportStatus,
                                      int createUser,
                                      int auditorID);

    UnifiedResponse changeScore(ExperimentReportDTO dto);
}
