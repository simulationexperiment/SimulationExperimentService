package com.johnny.simulationexperimentservice.entity;

import lombok.Data;

@Data
public class UserEntity extends BaseEntity {
    private int userID;
    private String cellphone;
    private String userCode;
    private String fullName;
    private String sex;
    private String sexText;
    private String userRole;
    private String userRoleText;
    private String email;
    private String password;
}
