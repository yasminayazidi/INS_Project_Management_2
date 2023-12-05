package com.ins.biz.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ins.biz.entities.Utilisateur;
import com.ins.biz.enums.Role;


public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	  List<Utilisateur> findByRole(Role role);

	 boolean existsByEmail(String email);

	 Optional<Utilisateur> findOneByEmail(String username);
	}
