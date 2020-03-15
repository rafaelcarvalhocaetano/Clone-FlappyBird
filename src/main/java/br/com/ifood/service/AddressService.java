package br.com.ifood.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ifood.dto.AddressDTO;
import br.com.ifood.exceptions.UserException;
import br.com.ifood.repository.AddressRespository;

@Service
public class AddressService {

  @Autowired
  private AddressRespository respository;

  public Iterable<AddressDTO> listAddress() {
    return new AddressDTO().convertAddress(respository.findAll());
  }

  public ResponseEntity<AddressDTO> createAddress(AddressDTO dto) {
    try {
      respository.save(new AddressDTO().convertDtoToEnity(dto));
      return ResponseEntity.ok().build();
    } catch (UserException e) {
      throw new UserException("Erro ao salvar Endereço");
    }
  }

  
}