package io.github.rozarioc33art.markdownnoteapp.controller;

import io.github.rozarioc33art.markdownnoteapp.dto.CreateNoteRequest;
import io.github.rozarioc33art.markdownnoteapp.dto.MarkdownFileResponse;
import io.github.rozarioc33art.markdownnoteapp.dto.PreviewRequest;
import io.github.rozarioc33art.markdownnoteapp.dto.UpdateNoteRequest;
import io.github.rozarioc33art.markdownnoteapp.entity.Note;
import io.github.rozarioc33art.markdownnoteapp.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/api/notes")
    public ResponseEntity<Note> createNote(@Valid @RequestBody CreateNoteRequest request) {
//      throws method_argument_not_valid exception

        Note note = new Note();

//      copy title, content
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        Note savedNote = noteService.createNote(note);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedNote);
    }

    @GetMapping("/api/notes")
    public ResponseEntity<List<Note>> getAllNotes() {

        List<Note> notes = noteService.getAllNotes();
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/api/notes/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {

        Note note = noteService.getNoteById(id);
        return ResponseEntity.ok(note);
    }

    @PutMapping("/api/notes/{id}")
    public ResponseEntity<Note> updateNote(
            @PathVariable Long id,
            @Valid @RequestBody UpdateNoteRequest request) {

        Note note = new Note();
        note.setTitle(request.getTitle());
        note.setContent(request.getContent());

        Note updatedNote = noteService.updateNote(id, note);
        return ResponseEntity.ok(updatedNote);
    }

    @DeleteMapping("/api/notes/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/api/preview")
    public ResponseEntity<String> toHtml(@RequestBody PreviewRequest request) {
        String html = noteService.toHtml(request.getContent());
        return ResponseEntity.ok(html);
    }

    @PostMapping("/api/notes/upload")
    public ResponseEntity<MarkdownFileResponse> uploadMarkdown(
            @RequestParam("file")MultipartFile file
            ) throws IOException {

        return ResponseEntity.ok(noteService.uploadMarkdown(file));
    }

}