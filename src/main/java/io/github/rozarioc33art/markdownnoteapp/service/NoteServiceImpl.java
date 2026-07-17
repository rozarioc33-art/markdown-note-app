package io.github.rozarioc33art.markdownnoteapp.service;

import io.github.rozarioc33art.markdownnoteapp.entity.Note;
import io.github.rozarioc33art.markdownnoteapp.exception.NoteNotFoundException;
import io.github.rozarioc33art.markdownnoteapp.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService{

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
//        Optional<Note> noteOptional = noteRepository.findById(id);
//        if (noteOptional.isPresent()) {
//            return noteOptional.get();
//        }
//        return null;
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    @Override
    public Note updateNote(Long id, Note note) {

        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));

        existingNote.setTitle(note.getTitle());
        existingNote.setContent(note.getContent());

        return noteRepository.save(existingNote);
    }

    @Override
    public void deleteNote(Long id) {

        Note existingNote = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));

        noteRepository.delete(existingNote);
    }


}
