package com.zplus.schoolmaster.model;

import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "school_details")
public class SchoolMasterModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer schoolId;

    @Column
    @Valid
    @NotNull(message="name is required")
    private String name;

    @Column
    private String schoolAddress;

    @Column
    @Valid
    @NotNull(message="contactNo is required")
    private String contactNo;

    @Column
    private Integer totalStudent;

    @Column
    private Integer totalTeacher;

    @Column
    private Integer totalBranch;
    @Column
    private Integer revenueAmount;
    @Column
    private String schoolStatus;

    @Temporal(TemporalType.DATE)
    private Date todayDate;

    private String password;

    private String emailId;


}
