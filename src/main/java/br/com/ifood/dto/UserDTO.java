package br.com.ifood.dto;

import br.com.ifood.model.User;

public class UserDTO {

  private String id;
  private String name;
  private String email;
  private String phoneNumber;
  private String cpf;


  public UserDTO() {  }

  public UserDTO(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
    this.phoneNumber = user.getPhoneNumber();
    this.cpf = user.getcpf();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getCpd() {
    return cpf;
  }

  public void setCpd(String cpd) {
    this.cpf = cpd;
  }
  
  
}