package com.inssolutions.BIZMinderAPI.validator;

import com.inssolutions.BIZMinderAPI.DTO.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {
        // todo return if null
    public static List<String> validate (EntrepriseDto entrepriseDto){
        List<String> errors =new ArrayList<>();
        if(!StringUtils.hasLength(entrepriseDto.getCorporateName())){
            errors.add("Veuillez renseigner la raison social de sociéte !!");
        }

        return errors;
    }
}
