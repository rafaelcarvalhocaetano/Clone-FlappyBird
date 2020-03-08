package br.com.ifood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifood.dto.UserDTO;
import br.com.ifood.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(value = "User Endpoint", description = "User List API´S", tags = {"USER - END POINT"})
@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService service;

  @ApiOperation(value = "Find All User in the IFood")
  @GetMapping
  public Iterable<UserDTO> findAllUser() {
    return this.service.listUser();
  }

  @ApiOperation(value = "Create User to list User in IFood")
  @PostMapping
  public ResponseEntity<UserDTO> create(@RequestBody UserDTO user) {      
    return service.createUser(user);
  }
  
  
}