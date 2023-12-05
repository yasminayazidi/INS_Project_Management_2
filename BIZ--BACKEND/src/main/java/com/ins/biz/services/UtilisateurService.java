package com.ins.biz.services;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.ins.biz.dto.UtilisateurDto;
import com.ins.biz.enums.Role;
import com.ins.biz.exceptions.ExistException;

import java.util.List;

public interface UtilisateurService  extends UserDetailsService {


  public UtilisateurDto findById(Long id) throws ExistException;

  public List<UtilisateurDto> findByRole(Role role);

  UtilisateurDto findByEmail(String email);
}
