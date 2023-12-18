package com.inssolutions.BIZMinderAPI.validator;

import com.inssolutions.BIZMinderAPI.DTO.HolidayDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class HolidyasValidator {

    public static List<String> validate(HolidayDto dto){
        List<String> errors =new ArrayList<>();;
        if(dto == null){
            errors.add("");
            return errors;
        }
        if(!StringUtils.hasLength(dto.getLocation()))
            errors.add("Location est null !!");
        if(!StringUtils.hasLength(dto.getShift()))
            errors.add("shift est null !!");
        if(!StringUtils.hasLength(dto.getName()))
            errors.add("Name est null !!");
        if(!StringUtils.hasLength(dto.getDetails()))
            errors.add("Details est null !!");


        return errors;
    }
}
