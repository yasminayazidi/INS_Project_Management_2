package com.inssolutions.BIZMinderAPI.service.impl;

import com.inssolutions.BIZMinderAPI.DTO.EntrepriseDto;
import com.inssolutions.BIZMinderAPI.enumeration.ErrorCode;
import com.inssolutions.BIZMinderAPI.exception.InvalidEntityException;
import com.inssolutions.BIZMinderAPI.reposotery.EntrepriseRepository;
import com.inssolutions.BIZMinderAPI.service.EntrepriseService;
import com.inssolutions.BIZMinderAPI.validator.EntrepriseValidator;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class EntrepriseServiceImp implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository;

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
            // todo validate
        List<String> errors = EntrepriseValidator.validate(dto);
        if (!errors.isEmpty()){
            log.error("Entreprise is not valid {}", dto);
            throw new InvalidEntityException("L'entreprise n'est pas valide", ErrorCode.ENTREPRISE_NOT_VALID,errors);
        }
            // todo error
        return EntrepriseDto.fromEntity( // pour transformer notre entite vers dto ==> obligation de type de retour de methode save
                entrepriseRepository.save(EntrepriseDto.toEntity(dto)) // pour transformer notre dto vers entité
        );

    }
}
