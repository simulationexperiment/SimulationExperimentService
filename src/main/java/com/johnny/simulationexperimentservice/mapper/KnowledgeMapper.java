package com.johnny.simulationexperimentservice.mapper;

import com.johnny.simulationexperimentservice.entity.KnowledgeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KnowledgeMapper extends BaseMapper<KnowledgeEntity> {
    List<KnowledgeEntity> searchListByContent(int startIndex, int pageSize, int systemID, int userID);
}
