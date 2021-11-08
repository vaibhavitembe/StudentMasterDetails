package com.zplus.schoolmaster.Service;

import com.zplus.schoolmaster.dto.ForgotPassReqDto;
import com.zplus.schoolmaster.dto.SchoolConcectNoNameReqDto;
import com.zplus.schoolmaster.dto.SchoolMasterDto;
import com.zplus.schoolmaster.model.SchoolMasterModel;

import java.util.Date;
import java.util.List;

public interface SchoolMasterService {
    Boolean insertSchool(SchoolMasterDto schoolMasterDto);

    Boolean UpdateSchool(SchoolMasterDto schoolMasterDto);

    List getAllSchool();

    SchoolMasterModel getBySchoolId(Integer schoolId);

    List FindOrderById();

    List activeSchoolDetails();

    Boolean deleteSchoolById(Integer schoolId);




    List FindGroupById();


    List findByContactNoAndName(SchoolConcectNoNameReqDto schoolConcectNoNameReqDto);

    List findSumOfAmountGroupByAddress();


    List findBySchoolAddressAndTotalStudent(String schoolAddress, Integer totalStudent);

    Boolean forgotPassword(ForgotPassReqDto forgotPassReqDto);

    List getBySchoolTodayDate(Date schoolStartDate, Date schoolEndDate);
}
