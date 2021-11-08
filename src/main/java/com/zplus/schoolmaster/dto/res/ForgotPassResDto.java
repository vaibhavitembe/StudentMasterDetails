package com.zplus.schoolmaster.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForgotPassResDto {
    private String contactNo;
    private String emailId;
    private String password;
    private Integer ResponseCode;
    private String message;
}
