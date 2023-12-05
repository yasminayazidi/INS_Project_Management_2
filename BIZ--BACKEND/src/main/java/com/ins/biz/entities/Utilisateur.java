package com.ins.biz.entities;

import java.util.List;

import com.ins.biz.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


	@Entity
	@Data
	public class Utilisateur {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String nom;
	  private String prenom;
	  private String email;
	  private String password;

	  @Enumerated(EnumType.STRING)
	  private Role role;
//	  @OneToMany(mappedBy = "utilisateur")
//	  private List<Commentaire> commentaires;
//
//	  @OneToMany(mappedBy = "utilisateur")
//	  private List<Tache> taches;
	

}
