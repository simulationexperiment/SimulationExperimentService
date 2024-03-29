package com.johnny.simulationexperimentservice.mapper;

import com.johnny.simulationexperimentservice.entity.TeachingResourceEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeachingResourceMapper extends BaseMapper<TeachingResourceEntity> {
    int searchTotalCountByContent(int systemID,
                                  int courseID,
                                  int resourceTypeID,
                                  String resourceStatus,
                                  int auditorID);

    List<TeachingResourceEntity> searchListByContent(int startIndex,
                                                     int pageSize,
                                                     int systemID,
                                                     int courseID,
                                                     int resourceTypeID,
                                                     String resourceStatus,
                                                     int auditorID);

    int changeStatus(TeachingResourceEntity entity);
}
