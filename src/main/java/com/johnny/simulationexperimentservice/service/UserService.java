package com.johnny.simulationexperimentservice.service;

import com.johnny.simulationexperimentservice.dto.UserDTO;
import com.johnny.simulationexperimentservice.entity.UserEntity;
import com.johnny.simulationexperimentservice.vo.UnifiedResponse;
import com.johnny.simulationexperimentservice.vo.UserVO;

public interface UserService extends BaseService<UserDTO, UserVO, UserEntity> {
    UnifiedResponse findList(int pageNumber, int pageSize, String userRole);

    UnifiedResponse login(String cellphone, String password);
}
