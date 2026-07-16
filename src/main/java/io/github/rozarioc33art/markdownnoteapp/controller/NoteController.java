package io.github.rozarioc33art.markdownnoteapp.controller;

import io.github.rozarioc33art.markdownnoteapp.entity.Note;
import io.github.rozarioc33art.markdownnoteapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/api/notes")
    public Note createNote(@RequestBody Note note) {
        return noteService.createNote(note);
    }

}
