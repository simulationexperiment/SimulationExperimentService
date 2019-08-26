package com.johnny.simulationexperimentservice.mapper;

import com.johnny.simulationexperimentservice.entity.AnswerEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnswerMapper extends BaseMapper<AnswerEntity> {
    int searchTotalCountByContent(int questionID);

    List<AnswerEntity> searchListByContent(int startIndex, int pageSize, int questionID);

    int deleteByQuestion(int question);
}