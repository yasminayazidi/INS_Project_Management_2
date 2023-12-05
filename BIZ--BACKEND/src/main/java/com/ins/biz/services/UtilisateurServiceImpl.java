package com.ins.biz.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ins.biz.dto.UtilisateurDto;
import com.ins.biz.entities.Utilisateur;
import com.ins.biz.enums.Role;
import com.ins.biz.exceptions.ExistException;
import com.ins.biz.repositories.UtilisateurRepository;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {
  @Autowired
  private ModelMapper modelMapper;
  @Autowired
  private UtilisateurRepository utilisateurRepository;




  @Override
  public UtilisateurDto findById(Long id) throws ExistException {
    return modelMapper.map(utilisateurRepository.findById(id).orElseThrow(() -> new ExistException("Utilisateur n'existe pas")), UtilisateurDto.class);
  }

  @Override
  public List<UtilisateurDto> findByRole(Role role){
   return utilisateurRepository.findByRole(role).stream().map(utilisateur -> modelMapper.map(utilisateur, UtilisateurDto.class)).collect(Collectors.toList());
  }

  @Override
  public UtilisateurDto findByEmail(String email) {
    return modelMapper.map(utilisateurRepository.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Utilisateur n'existe pas")), UtilisateurDto.class);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Utilisateur utilisateur = utilisateurRepository.findOneByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Utilisateur n'existe pas"));
    return  User.builder()
      .username(utilisateur.getEmail())
      .password(utilisateur.getPassword())
      .authorities(Arrays.asList(new SimpleGrantedAuthority(utilisateur.getRole().name())))
      .build();
  }


}