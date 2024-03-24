package br.devshy.riotgiftproxy.config;

import br.devshy.riotgiftproxy.exception.HydraAuthFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HydraExceptionHandler {
    @ExceptionHandler(HydraAuthFailedException.class)
    public ResponseEntity<Void> handleHydraAuthFailedException(HydraAuthFailedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
