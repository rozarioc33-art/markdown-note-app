package io.github.rozarioc33art.markdownnoteapp.controller;

import io.github.rozarioc33art.markdownnoteapp.entity.Note;
import io.github.rozarioc33art.markdownnoteapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/api/notes")
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }

    @GetMapping("/api/notes")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("api/notes/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @PutMapping("api/notes/{id}")
    public ResponseEntity<Note> updateNote(
            @PathVariable Long id,
            @RequestBody Note updatedNote) {

        Note note = noteService.updateNote(id, updatedNote);
        return ResponseEntity.ok(note);
    }

    @DeleteMapping("/api/notes/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return ResponseEntity.noContent().build();
    }

}