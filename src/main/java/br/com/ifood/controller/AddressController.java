package br.com.ifood.controller;

import br.com.ifood.dto.AddressDTO;
import br.com.ifood.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/address")
public class AddressController {


  @Autowired
  private AddressService service;

  @GetMapping
  public ResponseEntity<Iterable<AddressDTO>> getAllAddress() {
    return ResponseEntity.ok().build();
  }

  @PostMapping
  public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO dto) {
    return service.createAddress(dto);
  }
}
