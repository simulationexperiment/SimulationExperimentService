package com.johnny.simulationexperimentservice.mapper;

import com.johnny.simulationexperimentservice.entity.ExperimentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExperimentMapper extends BaseMapper<ExperimentEntity> {
    List<ExperimentEntity> searchListByContent(int startIndex, int pageSize, int systemID, int courseID, int experimentTypeID);
}
