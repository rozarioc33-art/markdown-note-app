package io.github.rozarioc33art.markdownnoteapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoteNotFound(NoteNotFoundException ex) {

//        ex.printStackTrace();
        ErrorResponse error = new ErrorResponse(ex.getMessage());
//        .getMessage() comes from the runtime exception class.

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

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        String message = fieldErrors.getDefaultMessage();

        ErrorResponse error = new ErrorResponse(message);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
        }
}
