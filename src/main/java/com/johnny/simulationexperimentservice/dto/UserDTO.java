package com.johnny.simulationexperimentservice.dto;

import lombok.Data;

@Data
public class UserDTO extends BaseDTO {
    private int userID;
    private String cellphone;
    private String userCode;
    private String fullName;
    private String sex;
    private String userRole;
    private String email;
    private String password;
}
