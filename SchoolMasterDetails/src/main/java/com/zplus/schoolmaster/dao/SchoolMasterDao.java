package com.zplus.schoolmaster.dao;

import com.zplus.schoolmaster.model.SchoolMasterModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface SchoolMasterDao extends CrudRepository<SchoolMasterModel, Integer> {


    @Query("From SchoolMasterModel as sm ORDER BY schoolId DESC")
    List FindOrderById();

    List findBySchoolStatus(String active);
    @Query("From SchoolMasterModel as sm WHERE sm.todayDate Between date(:schoolStartDate) AND date(:schoolEndDate)")

    List findBySchoolTodayDate(@Param("schoolStartDate") Date schoolStartDate, @Param("schoolEndDate") Date schoolEndDate);
    @Query("From SchoolMasterModel as sm  Group By sm.schoolAddress")

    List FindGroupById();


    List findAllByContactNoAndName(String contactNo, String name);

    @Query("select new com.zplus.schoolmaster.dto.res.ResDto(sum(sm.revenueAmount),sm.schoolAddress) from SchoolMasterModel as sm group by sm.schoolAddress")
    List findSumOfAmountGroupByAddress();


    List findByTotalStudentGreaterThanAndSchoolAddress(int i, String schoolAddress);

    SchoolMasterModel findByEmailIdOrContactNo(String userName, String userName1);
}

