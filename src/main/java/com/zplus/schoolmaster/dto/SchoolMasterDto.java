package com.zplus.schoolmaster.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

public class SchoolMasterDto {
    private Integer schoolId;

    private String name;

    private String schoolAddress;

    private String contactNo;

    private Integer totalStudent;

    private Integer totalTeacher;

    private Integer totalBranch;

    private Integer revenueAmount;

    private String status;

    private Date todayDate;

    private String password;

    private String emailId;
}
