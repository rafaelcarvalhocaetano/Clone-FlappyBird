package br.com.ifood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.ifood.dto.UserDTO;
import br.com.ifood.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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


  @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseEntity<Object> uploader(@RequestParam("file") MultipartFile file) throws IOException {

    File convertFile = new File(file.getOriginalFilename());
    convertFile.createNewFile();
    FileOutputStream fileOutputStream = new FileOutputStream(convertFile);
    fileOutputStream.write(file.getBytes());
    fileOutputStream.close();
    return new ResponseEntity<>("File is Uploaded successfully" + file, HttpStatus.OK);
  }
  
  
}