package com.inssolutions.BIZMinderAPI.DTO;

import com.inssolutions.BIZMinderAPI.model.Entreprise;
import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class EntrepriseDto {

    private Integer id;
    private String corporateName;
    private String phone;
    private String logo;
    private String email;

    public static EntrepriseDto fromEntity(Entreprise entreprise){

        if ( entreprise == null){
            return null;
        }

        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .corporateName(entreprise.getCorporateName())
                .email(entreprise.getEmail())
                .logo((entreprise.getLogo()))
                .phone(entreprise.getPhone())
                .build();
    }
    public static Entreprise toEntity(EntrepriseDto entrepriseDto){
        if ( entrepriseDto == null){
            return null;
        }
        Entreprise entreprise = new Entreprise();
        entreprise.setLogo(entrepriseDto.getLogo());
        entreprise.setPhone(entrepriseDto.getPhone());
        entreprise.setEmail(entrepriseDto.getEmail());
        entreprise.setCorporateName(entrepriseDto.getCorporateName());
        entreprise.setId(entrepriseDto.getId());

        return entreprise;

    }

}
