package br.com.ifood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ifood.model.User;
import br.com.ifood.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public ResponseEntity<Iterable<User>> listUser() {
    return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
  }

  public ResponseEntity<User> createUser(User user) {
    userRepository.save(user);
    return ResponseEntity.ok().build();
  }
  
}