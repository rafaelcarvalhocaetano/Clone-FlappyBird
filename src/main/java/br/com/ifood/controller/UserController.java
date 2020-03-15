package br.com.ifood.controller;

import br.com.ifood.service.UploadService;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ifood.dto.UserDTO;
import br.com.ifood.model.User;
import br.com.ifood.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Api(value = "User Endpoint", description = "User List API´S", tags = {"USER - END POINT"})
@RestController
@RequestMapping(value = "/user")
public class UserController {

  @Autowired
  private UserService service;

  @Autowired
  private UploadService photoService;

  @ApiOperation(value = "Find All User in the IFood")
  @GetMapping
  public ResponseEntity<Iterable<UserDTO>> findAllUser() {
    Iterable<UserDTO> user = service.listUser();
    return ResponseEntity.ok().body(user);
  }

  @ApiOperation(value = "Find Id User in the IFood")
  @GetMapping(value = "/{id}")
  public ResponseEntity<UserDTO> findByIdUser(@PathVariable("id") String id) {
    User user = service.getId(id);
    return ResponseEntity.ok().body(new UserDTO(user));
  }
  

  @ApiOperation(value = "Create User to list User in IFood")
  @PostMapping
  public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
    User user = service.convertToDto(dto);
    service.createUser(user);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    return ResponseEntity.created(uri).build();
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO dto,  @PathVariable("id") String id) {
    User user = service.convertToDto(dto);
    user.setId(id);
    user = service.updateUser(user);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<UserDTO> deleteUser(@PathVariable("id") String id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping(
    value = "/fotos",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
  )
  public ResponseEntity<Void> photo(@RequestParam("photo") MultipartFile photo) {
    photoService.savePhoto(photo);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(photo.getName()).toUri();
    return ResponseEntity.created(uri).build();
  }
 
  
}