package com.johnny.simulationexperimentservice.mapper;

import com.johnny.simulationexperimentservice.entity.LaboratoryAppointmentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LaboratoryAppointmentMapper extends BaseMapper<LaboratoryAppointmentEntity> {
    int searchTotalCountByContent(String fromDate, String toDate);

    int searchScheduledCountByContent(String laboratoryDate, int courseOrder, int laboratoryID);

    List<LaboratoryAppointmentEntity> searchListByContent(int startIndex, int pageSize, String fromDate, String toDate);
}
