package com.ins.biz.config;


import java.util.ArrayList;

import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component

public class JwtUtil {
  @Value("${jwt-token-validity}")
  private long tokenValidity;
  @Value("${jwt-secret-key}")
  private String secretKey;


  public String generateToken(Authentication authentication) {
    String subject = authentication.getName();
    List<String> roles = new ArrayList<>();
    authentication.getAuthorities().forEach(auth -> roles.add(auth.getAuthority()));
    String token = Jwts.builder().setSubject(subject).claim("roles", roles).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + tokenValidity)) // in milliseconds
      .signWith(SignatureAlgorithm.HS512, secretKey).compact();
    return token;
  }


  public String getUsernameFromToken(String token) {
    return getAllClaimsFromToken(token).getSubject();
  }


  public List<GrantedAuthority> getAuthorityFromToken(String token) {


    List<String> roles = getAllClaimsFromToken(token).get("roles", List.class);


    List<GrantedAuthority> authorities = new ArrayList<>();
    roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));

    return authorities;

  }

  private Claims getAllClaimsFromToken(String token) {

    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
  }

}

