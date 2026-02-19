package com.upride.platform.exception;


import com.upride.platform.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleValidationErrors(MethodArgumentNotValidException ex) {
        // On récupère le message que tu as défini dans @Email(message = "...")
        String message = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();

        Response response = new Response();
        response.setStatusCode(400);
        response.setMessage(message);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Tu peux aussi ajouter un handler pour ton OurException ici pour centraliser
    @ExceptionHandler(OurException.class)
    public ResponseEntity<Response> handleOurException(OurException ex) {
        Response response = new Response();
        response.setStatusCode(400);
        response.setMessage(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
