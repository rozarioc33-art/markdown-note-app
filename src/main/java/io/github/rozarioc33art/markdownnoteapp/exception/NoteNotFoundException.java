package io.github.rozarioc33art.markdownnoteapp.exception;

public class NoteNotFoundException extends RuntimeException{

//    passing the message to be stored to runtime exception.
    public NoteNotFoundException(Long id) {
        super("Note not found with id: " + id);
    }
}
