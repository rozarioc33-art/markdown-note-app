package io.github.rozarioc33art.markdownnoteapp.exception;

public class NoteNotFoundException extends RuntimeException{

    public NoteNotFoundException(Long id) {
        super("Note not found with id: " + id);
    }
}
