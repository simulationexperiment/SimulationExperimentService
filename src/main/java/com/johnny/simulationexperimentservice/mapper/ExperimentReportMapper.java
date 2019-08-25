package com.johnny.simulationexperimentservice.mapper;

import com.johnny.simulationexperimentservice.entity.ExperimentReportEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExperimentReportMapper extends BaseMapper<ExperimentReportEntity> {
    int searchTotalCountByContent(int systemID,
                                  int courseID,
                                  int experimentTypeID,
                                  String reportStatusID,
                                  int createUser,
                                  int auditorID);

    List<ExperimentReportEntity> searchListByContent(int startIndex,
                                                     int pageSize,
                                                     int systemID,
                                                     int courseID,
                                                     int experimentTypeID,
                                                     String reportStatusID,
                                                     int createUser,
                                                     int auditorID);

    int updateScore(ExperimentReportEntity entity);
}
