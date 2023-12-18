package com.inssolutions.BIZMinderAPI.validator;

import com.inssolutions.BIZMinderAPI.DTO.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate (EntrepriseDto entrepriseDto){
        List<String> errors =new ArrayList<>();
        //  if dto null
        if (entrepriseDto == null){
            errors.add("Veuillez renseigner la raison social de sociéte !!");
            return errors;
        }

        if(!StringUtils.hasLength(entrepriseDto.getCorporateName())){
            errors.add("Veuillez renseigner la raison social de sociéte !!");
        }

        return errors;
    }
}
