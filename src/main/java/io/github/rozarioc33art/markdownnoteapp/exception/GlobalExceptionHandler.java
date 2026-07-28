package io.github.rozarioc33art.markdownnoteapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoteNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoteNotFound(NoteNotFoundException ex) {

//        ex.printStackTrace();
        ErrorResponse error = new ErrorResponse(ex.getMessage());
//        .getMessage() comes from the runtime exception class.
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }
}
