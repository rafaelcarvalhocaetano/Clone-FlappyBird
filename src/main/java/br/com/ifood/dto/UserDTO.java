package br.com.ifood.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ifood.model.Address;
import br.com.ifood.model.User;

public class UserDTO {

  private String id;
  private String name;
  private String email;
  private String phoneNumber;
  private String cpf;
  private Address address;


  public UserDTO() {  }

  public UserDTO(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.phoneNumber = user.getPhoneNumber();
    this.cpf = user.getCpf();
    this.address = user.getAddress();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public List<UserDTO> converteUserList(List<User> users) {
    return users.stream().map(UserDTO::new).collect(Collectors.toList());
  }

  public UserDTO convertPersonToDTO(User user) {
    UserDTO dto = new UserDTO();
    dto.setId(user.getId());
    dto.setName(user.getName());
    dto.setEmail(user.getEmail());
    dto.setPhoneNumber(user.getPhoneNumber());
    dto.setCpf(user.getCpf());
    return dto;
  }

  public User converterPersonDTOPerson(UserDTO dto) {
    User user = new User();
    user.setId(dto.getId());
    user.setName(dto.getName());
    user.setEmail(dto.getEmail());
    user.setPhoneNumber(dto.getPhoneNumber());
    user.setCpf(dto.getCpf());
    return user;
  }
}