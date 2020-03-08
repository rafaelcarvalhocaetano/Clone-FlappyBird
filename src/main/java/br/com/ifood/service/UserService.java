package br.com.ifood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ifood.dto.UserDTO;
import br.com.ifood.exceptions.UserException;
import br.com.ifood.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public Iterable<UserDTO> listUser() {
    return new UserDTO().converteUserList(userRepository.findAll());
  }

  public ResponseEntity<UserDTO> createUser(UserDTO user) {
    try {
      userRepository.save(new UserDTO().converterPersonDTOPerson(user));
      return ResponseEntity.ok().build();
    } catch (UserException e) {
      throw new UserException("Erro ao salvar Usuário");
    }
  }
  
}