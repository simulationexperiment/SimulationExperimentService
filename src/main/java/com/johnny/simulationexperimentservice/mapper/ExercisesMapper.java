package com.johnny.simulationexperimentservice.mapper;

import com.johnny.simulationexperimentservice.entity.ExercisesEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExercisesMapper extends BaseMapper<ExercisesEntity> {

    int searchTotalCountByContent(int systemID, int knowledgeID, int userID);

    List<ExercisesEntity> searchListByContent(int startIndex, int pageSize, int systemID, int knowledgeID, int userID);
}
