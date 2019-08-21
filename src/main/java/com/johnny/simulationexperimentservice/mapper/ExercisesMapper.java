package com.johnny.simulationexperimentservice.mapper;

import com.johnny.simulationexperimentservice.entity.ExercisesEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExercisesMapper extends BaseMapper<ExercisesEntity> {
    List<ExercisesEntity> searchListByContent(int startIndex, int pageSize, int systemID, int knowledgeID, int userID);
}
