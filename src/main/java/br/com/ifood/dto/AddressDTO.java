package br.com.ifood.dto;
import br.com.ifood.enums.AddressType;

import br.com.ifood.model.Address;

import java.util.List;
import java.util.stream.Collectors;

public class AddressDTO {

  private String id;
  private String street;
  private AddressType type;
  private String neighborhood;
  private String city;
  private String state;
  private String complement;

  public AddressDTO() {
  }


  public AddressDTO(String id) {
    this.id = id;
  }

   public AddressDTO(UserDTO dto) {
    this.id = dto.getId();
  }

  public AddressDTO(Address address) {
    this.id = address.getId();
    this.street = address.getStreet();
    this.type = address.getType();
    this.neighborhood = address.getNeighborhood();
    this.city = address.getCity();
    this.state = address.getState();
    this.complement = address.getComplement();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public AddressType getType() {
    return type;
  }

  public void setType(AddressType type) {
    this.type = type;
  }

  public String getNeighborhood() {
    return neighborhood;
  }

  public void setNeighborhood(String neighborhood) {
    this.neighborhood = neighborhood;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }


  public List<AddressDTO> convertAddress(List<Address> all) {
    return all.stream().map(AddressDTO::new).collect(Collectors.toList());
  }

  public Address convertDtoToEnity(AddressDTO address) {
    Address add = new Address();
    add.setId(address.getId());
    add.setStreet(address.getStreet());
    add.setType(address.getType());
    add.setNeighborhood(address.getNeighborhood());
    add.setCity(address.getCity());
    add.setState(address.getState());
    add.setComplement(address.getComplement());
    return add;
  }



 

  
  
}