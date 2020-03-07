package br.com.ifood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifood.model.User;
import br.com.ifood.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping
  public ResponseEntity<Iterable<User>> findAllUser() {
    return this.service.listUser();
  }

  @PostMapping
  public ResponseEntity<User> create(@RequestBody User user) {      
    return service.createUser(user);
  }
  
  
}