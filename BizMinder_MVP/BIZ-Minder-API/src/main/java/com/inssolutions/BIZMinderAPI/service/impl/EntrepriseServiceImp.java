package com.inssolutions.BIZMinderAPI.service.impl;

import com.inssolutions.BIZMinderAPI.DTO.EntrepriseDto;
import com.inssolutions.BIZMinderAPI.reposotery.EntrepriseRepository;
import com.inssolutions.BIZMinderAPI.service.EntrepriseService;

public class EntrepriseServiceImp implements EntrepriseService {
    private EntrepriseRepository entrepriseRepository;

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
            // todo validate
            // todo error
        return EntrepriseDto.fromEntity( // pour transformer notre entite vers dto ==> obligation de type de retour de methode save
                entrepriseRepository.save(EntrepriseDto.toEntity(dto)) // pour transformer notre dto vers entité
        );

    }
}
