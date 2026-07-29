package io.github.rozarioc33art.markdownnoteapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoteNotFound(NoteNotFoundException ex) {

//        ex.printStackTrace();
        List<String> messages = new ArrayList<>();
        messages.add(ex.getMessage());

        ErrorResponse error = new ErrorResponse(messages);

//        method chaining
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

//    exception type
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {

        //  System.out.println(ex.getBindingResult());
        BindingResult bindingResult = ex.getBindingResult();

//        fieldErrors is simply a java list
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        List<String> messages = new ArrayList<>();

//        for each
        for (FieldError error : fieldErrors) {
            messages.add(error.getDefaultMessage());
        }

        ErrorResponse error = new ErrorResponse(messages);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
        }
}
