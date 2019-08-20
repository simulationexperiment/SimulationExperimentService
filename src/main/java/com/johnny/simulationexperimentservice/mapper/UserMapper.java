package com.johnny.simulationexperimentservice.mapper;

import com.johnny.simulationexperimentservice.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
    int searchTotalCountByUserRole(@Param("userRole")  String userRole);

    List<UserEntity> searchListByUserCode(int startIndex, int pageSize, String userRole);
}
