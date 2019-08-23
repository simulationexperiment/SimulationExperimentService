package com.johnny.simulationexperimentservice.mapper;

import com.johnny.simulationexperimentservice.entity.ExperimentAssignEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExperimentAssignMapper extends BaseMapper<ExperimentAssignEntity>{
    List<ExperimentAssignEntity> searchListByContent(int startIndex, int pageSize, int systemID, int courseID, int experimentTypeID);
}
