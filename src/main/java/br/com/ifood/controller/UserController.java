package br.com.ifood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifood.dto.UserDTO;
import br.com.ifood.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping
  public Iterable<UserDTO> findAllUser() {
    return this.service.listUser();
  }

  @PostMapping
  public ResponseEntity<UserDTO> create(@RequestBody UserDTO user) {      
    return service.createUser(user);
  }
  
  
}