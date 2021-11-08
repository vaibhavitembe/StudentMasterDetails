package com.zplus.schoolmaster.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.validation.Valid;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Getter
@Setter


public class SchoolMasterDateReqDto {
    @Valid
    private Date schoolStartDate;

    @Valid
    private Date schoolEndDate;



}
