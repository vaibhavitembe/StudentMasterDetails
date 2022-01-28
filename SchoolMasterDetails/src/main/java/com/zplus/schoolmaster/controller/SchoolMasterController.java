package com.zplus.schoolmaster.controller;

import com.zplus.schoolmaster.Service.SchoolMasterService;
import com.zplus.schoolmaster.dto.ForgotPassReqDto;
import com.zplus.schoolmaster.dto.SchoolConcectNoNameReqDto;
import com.zplus.schoolmaster.dto.SchoolMasterDateReqDto;
import com.zplus.schoolmaster.dto.SchoolMasterDto;
import com.zplus.schoolmaster.model.SchoolMasterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "school")
public class SchoolMasterController {

    @Autowired
    private SchoolMasterService schoolMasterService;

    @PostMapping
    private ResponseEntity insertSchool(@RequestBody SchoolMasterDto schoolMasterDto) {
        Boolean flag = schoolMasterService.insertSchool(schoolMasterDto);
        return new ResponseEntity(flag, HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity UpdateSchool(@RequestBody SchoolMasterDto schoolMasterDto) {
        Boolean flag = schoolMasterService.UpdateSchool(schoolMasterDto);
        return new ResponseEntity(flag, HttpStatus.OK);

    }

    @GetMapping
    private ResponseEntity getAllSchool() {

        List list = schoolMasterService.getAllSchool();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/getSchoolId/{schoolId}")
     private ResponseEntity getBySchoolId(@PathVariable Integer schoolId) {
        SchoolMasterModel schoolMasterModel = schoolMasterService.getBySchoolId(schoolId);
        return new ResponseEntity(schoolMasterModel, HttpStatus.OK);
    }

    @GetMapping("/FindOrderById/")
    private ResponseEntity FindOrderById() {
        List list = schoolMasterService.FindOrderById();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping(value = "activeSchoolDetails")
    private ResponseEntity activeSchoolDetails() {
        List list = schoolMasterService.activeSchoolDetails();
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @DeleteMapping("/deleteBySchoolId/{schoolId}")
    private ResponseEntity deleteSchoolById(@PathVariable Integer schoolId) {
        Boolean flag = schoolMasterService.deleteSchoolById(schoolId);
        return new ResponseEntity(flag, HttpStatus.OK);

    }


    @PostMapping("/FindTodayDate/")

    private ResponseEntity getBySchoolTodayDate(@Validated @RequestBody SchoolMasterDateReqDto schoolMasterDateReqDto) throws Exception {

        List list = schoolMasterService.getBySchoolTodayDate(schoolMasterDateReqDto.getSchoolStartDate(), schoolMasterDateReqDto.getSchoolEndDate());
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @GetMapping("/FindGroupById/")
    private ResponseEntity FindGroupById() {
        List list = schoolMasterService.FindGroupById();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/findByContactNoAndName/")
    private ResponseEntity findByContactNoAndName(@RequestBody SchoolConcectNoNameReqDto schoolConcectNoNameReqDto) {
        List list = schoolMasterService.findByContactNoAndName(schoolConcectNoNameReqDto);
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @GetMapping(value = "/findSumOfAmountGroupByAddress/")
    private ResponseEntity findSumOfAmountGroupByAddress() {
        List list = schoolMasterService.findSumOfAmountGroupByAddress();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/findBySchoolAddressAndTotalStudent/{schoolAddress}/{totalStudent}")
    private ResponseEntity findBySchoolAddressAndTotalStudent(@PathVariable String schoolAddress, @PathVariable Integer totalStudent) {
        List list = schoolMasterService.findBySchoolAddressAndTotalStudent(schoolAddress, totalStudent);
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/forgotPassword")
    private ResponseEntity forgotPassword(@RequestBody ForgotPassReqDto forgotPassReqDto) {
        Boolean flag = schoolMasterService.forgotPassword(forgotPassReqDto);
        return new ResponseEntity(flag, HttpStatus.OK);
    }


}
