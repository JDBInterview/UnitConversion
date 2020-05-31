package datacor.unitConversion.controller;

import datacor.unitConversion.exception.InvalidConversionException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

  @ExceptionHandler(InvalidConversionException.class)
  public ResponseEntity<Object> handleInvalidConversionException(
      InvalidConversionException ex) {

    return ResponseEntity.status(400)
        .contentType(MediaType.APPLICATION_JSON).body(ex.getMessage());
  }
}
