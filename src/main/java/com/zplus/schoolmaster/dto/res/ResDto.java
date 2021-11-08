package com.zplus.schoolmaster.dto.res;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResDto {
    private Long sumOfPoint;

    private String address;
    private String schoolAddress;

    private String contactNo;



    public ResDto(Long sumOfPoint, String address) {
        this.sumOfPoint = sumOfPoint;
        this.address = address;
    }

    public ResDto(String schoolAddress, String contactNo) {
        this.schoolAddress = schoolAddress;
        this.contactNo = contactNo;
    }
}
