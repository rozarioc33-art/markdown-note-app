package io.github.rozarioc33art.markdownnoteapp.service;

import io.github.rozarioc33art.markdownnoteapp.dto.MarkdownFileResponse;
import io.github.rozarioc33art.markdownnoteapp.entity.Note;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface NoteService {

    Note createNote(Note note);
    List<Note> getAllNotes();
    Note getNoteById(Long id);
    Note updateNote(Long id, Note note);
    void deleteNote(Long id);
    String toHtml(String request);
    MarkdownFileResponse uploadMarkdown(MultipartFile file) throws IOException;

}
