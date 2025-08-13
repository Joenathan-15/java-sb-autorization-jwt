package fun.joenathan.securityEx.controller;

import fun.joenathan.securityEx.model.WebResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<WebResponse<String>>responseStatusException(ResponseStatusException responseStatusException){
        return ResponseEntity.status(responseStatusException.getStatusCode()).body(WebResponse.<String>builder().errors(responseStatusException.getReason()).build());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<WebResponse<String>>constrainViolationException(ConstraintViolationException constraintViolationException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(WebResponse.<String>builder().errors(constraintViolationException.getMessage()).build());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<WebResponse<String>>userNotFoundException(UsernameNotFoundException usernameNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(WebResponse.<String>builder().errors(usernameNotFoundException.getMessage()).build());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<WebResponse<String>>BadCredentialsException(BadCredentialsException badCredentialsException){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(WebResponse.<String>builder().errors("Email or password is incorrect").build());
    }
}
