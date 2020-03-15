package br.com.ifood.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifood.dto.AddressIdDTO;
import br.com.ifood.dto.UserDTO;
import br.com.ifood.exceptions.UserException;
import br.com.ifood.model.User;
import br.com.ifood.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public Iterable<UserDTO> listUser() {
    return new UserDTO().converteUserList(userRepository.findAll());
  }

  public User getId(String id) {
    Optional<User> obj = userRepository.findById(id);
    return obj.orElseThrow(() -> new UserException("Usuário não encontrado"));
   }

  public User createUser(User user) {
    try {
      return userRepository.save(user);
    } catch (UserException e) {
      throw new UserException("Erro ao salvar Usuário");
    }
  }

  public User updateUser(User userParams) {
    try {
      User user = getId(userParams.getId());
      return userRepository.insert(user);  
    } catch (Exception e) {
      throw new UserException("Usuário não atualizado");
    }
  }

  public void delete(String id) {
    getId(id);
    userRepository.deleteById(id);
  }

  public User convertToDto(UserDTO dto) {
    return new User(dto.getId(), dto.getName(), dto.getEmail(), dto.getPhoneNumber(), dto.getCpf());
  }
  
}