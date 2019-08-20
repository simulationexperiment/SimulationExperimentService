package com.johnny.simulationexperimentservice.vo;

import lombok.Data;

@Data
public class UserVO extends BaseVO {
    private int userID;
    private String cellphone;
    private String userCode;
    private String fullName;
    private String sex;
    private String userRole;
    private String email;
    private String password;
}
