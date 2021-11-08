package com.zplus.schoolmaster.Service.Impl;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.zplus.schoolmaster.Service.SchoolMasterService;
import com.zplus.schoolmaster.configuration.SendMailComponent;
import com.zplus.schoolmaster.dao.SchoolMasterDao;
import com.zplus.schoolmaster.dto.ForgotPassReqDto;
import com.zplus.schoolmaster.dto.SchoolConcectNoNameReqDto;
import com.zplus.schoolmaster.dto.SchoolMasterDto;
import com.zplus.schoolmaster.dto.res.ForgotPassResDto;
import com.zplus.schoolmaster.model.SchoolMasterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SchoolMasterServiceImpl implements SchoolMasterService {

    @Autowired
    private SchoolMasterDao schoolMasterDao;

    @Autowired
    private SendMailComponent sendMailComponent;

    @Override
    public Boolean insertSchool(SchoolMasterDto schoolMasterDto) {

        SchoolMasterModel schoolMasterModel = new SchoolMasterModel();

        schoolMasterModel.setName(schoolMasterDto.getName());
        schoolMasterModel.setSchoolAddress(schoolMasterDto.getSchoolAddress());
        schoolMasterModel.setContactNo(schoolMasterDto.getContactNo());
        schoolMasterModel.setTotalStudent(schoolMasterDto.getTotalStudent());
        schoolMasterModel.setTotalBranch(schoolMasterDto.getTotalBranch());
        schoolMasterModel.setTotalTeacher(schoolMasterDto.getTotalTeacher());
        schoolMasterModel.setRevenueAmount(schoolMasterDto.getRevenueAmount());
        schoolMasterModel.setTodayDate(schoolMasterDto.getTodayDate());
        schoolMasterModel.setPassword(schoolMasterDto.getPassword());
        schoolMasterModel.setEmailId(schoolMasterDto.getEmailId());
        schoolMasterModel.setSchoolStatus("Active");
        try {
            schoolMasterDao.save(schoolMasterModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Boolean UpdateSchool(SchoolMasterDto schoolMasterDto) {
        SchoolMasterModel schoolMasterModel = new SchoolMasterModel();

        schoolMasterModel.setSchoolId(schoolMasterDto.getSchoolId());
        schoolMasterModel.setName(schoolMasterDto.getName());
        schoolMasterModel.setSchoolAddress(schoolMasterDto.getSchoolAddress());
        schoolMasterModel.setContactNo(schoolMasterDto.getContactNo());
        schoolMasterModel.setTotalStudent(schoolMasterDto.getTotalStudent());
        schoolMasterModel.setTotalBranch(schoolMasterDto.getTotalBranch());
        schoolMasterModel.setTotalTeacher(schoolMasterDto.getTotalTeacher());
        schoolMasterModel.setRevenueAmount(schoolMasterDto.getRevenueAmount());
        schoolMasterModel.setTodayDate(schoolMasterDto.getTodayDate());
        schoolMasterModel.setSchoolStatus("Active");
        try {
            schoolMasterDao.save(schoolMasterModel);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getAllSchool() {
        {
            return (List) schoolMasterDao.findAll();
        }
    }

    @Override
    public SchoolMasterModel getBySchoolId(Integer schoolId) {
        SchoolMasterModel schoolMasterModel = new SchoolMasterModel();
        try {
            schoolMasterModel = schoolMasterDao.findOne(schoolId);
            return schoolMasterModel;
        } catch (Exception e) {
            e.printStackTrace();
            return schoolMasterModel;
        }
    }

    @Override
    public List FindOrderById() {
        List list = schoolMasterDao.FindOrderById();
        return list;
    }

    @Override
    public List activeSchoolDetails() {
        return schoolMasterDao.findBySchoolStatus("Active");
    }

    @Override
    public Boolean deleteSchoolById(Integer schoolId) {
        try {
            schoolMasterDao.delete(schoolId);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List getBySchoolTodayDate(Date schoolStartDate, Date schoolEndDate) {

        List list = schoolMasterDao.findBySchoolTodayDate(schoolStartDate, schoolEndDate);
        return list;
    }

    @Override
    public List FindGroupById() {
        List list = schoolMasterDao.FindGroupById();
        return list;
    }

    @Override
    public List findByContactNoAndName(SchoolConcectNoNameReqDto schoolConcectNoNameReqDto) {
        List list = schoolMasterDao.findAllByContactNoAndName(schoolConcectNoNameReqDto.getContactNo(), schoolConcectNoNameReqDto.getName());
        return list;
    }

    @Override
    public List findSumOfAmountGroupByAddress() {
        List list = schoolMasterDao.findSumOfAmountGroupByAddress();
        return list;
    }

    @Override
    public List findBySchoolAddressAndTotalStudent(String schoolAddress, Integer totalStudent) {
        List list = schoolMasterDao.findByTotalStudentGreaterThanAndSchoolAddress(totalStudent, schoolAddress);
        return list;
    }

    @Override
    public Boolean forgotPassword(ForgotPassReqDto forgotPassReqDto) {
        ForgotPassResDto forgotPassResDto = new ForgotPassResDto();

        SchoolMasterModel schoolMasterModel = schoolMasterDao.findByEmailIdOrContactNo(forgotPassReqDto.getUserName(), forgotPassReqDto.getUserName());
        if (schoolMasterModel == null) {
            forgotPassResDto.setMessage("Mobile Number or emailId not Found");

            return false;
        } else {
            forgotPassResDto.setMessage("Mobile Number Or EmailId is Found");
            String content = "Hello," + schoolMasterModel.getName() + ".Your Password is " + schoolMasterModel.getPassword();
            String subject = "Your Forgot Password is ";
            Thread thread = new Thread(()
                    -> {
                try {
                    sendMailComponent.sendMail(schoolMasterModel.getEmailId(), content, subject);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
            );
            thread.start();
            return true;
        }
    }

}

//    @Override
//    public List getBySchoolTodayDate(Date schoolStartDate, Date schoolEndDate) {
//        List list=schoolMasterDao.findBySchoolTodayDate(schoolStartDate,schoolEndDate);
//        return list;
//    }


