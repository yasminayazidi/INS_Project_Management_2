package com.ins.biz.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ins.biz.enums.Role;

import lombok.Data;

/**
 * DTO for {@link com.ins.projet.entities.Utilisateur}
 */
@Data
public class UtilisateurDto implements Serializable {
  private Long id;
  private String nom;
  private String prenom;
  private String email;
  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  private String password;
  private Role role;
}
