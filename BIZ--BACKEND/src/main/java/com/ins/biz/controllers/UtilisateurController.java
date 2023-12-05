package com.ins.biz.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ins.biz.dto.UtilisateurDto;
import com.ins.biz.enums.Role;
import com.ins.biz.exceptions.ExistException;
import com.ins.biz.services.UtilisateurService;


@RestController
@RequestMapping("/utilisateur")
@CrossOrigin("*")
public class UtilisateurController {


  @Autowired
  private UtilisateurService utilisateurService;



  @GetMapping("/{id}")
  public UtilisateurDto findById(@PathVariable Long id) throws ExistException {
    return utilisateurService.findById(id);
  }

  @GetMapping("/role/{role}")
  public List<UtilisateurDto> findByRole(@PathVariable Role role) {
    return utilisateurService.findByRole(role);
  }

}