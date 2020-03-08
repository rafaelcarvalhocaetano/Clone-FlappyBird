package br.com.ifood.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public UserException(String exception) {
    super(exception);
  }

  
}