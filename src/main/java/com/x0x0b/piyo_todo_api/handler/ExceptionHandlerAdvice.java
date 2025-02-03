package com.x0x0b.piyo_todo_api.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

  @ExceptionHandler(NoResourceFoundException.class)
  public ResponseEntity<Object> handle(NoResourceFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object> handle(Exception e) {
    log.error(e.getMessage(), e);
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
  }

}
