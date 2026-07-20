package io.github.rozarioc33art.markdownnoteapp.service;

import io.github.rozarioc33art.markdownnoteapp.entity.Note;
import io.github.rozarioc33art.markdownnoteapp.exception.NoteNotFoundException;
import io.github.rozarioc33art.markdownnoteapp.repository.NoteRepository;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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

    @Override
    public String toHtml(String request) {

//      Class provided by CommonMark library
        Parser parser = Parser.builder().build();
//      Builder() returns builder obj
//      builder stores configuration
//      parser contains the created parser obj

        Node document = parser.parse(request);
//      Node node = parser.parse(request);
//      the parser reads the Markdown and understands its structure.

        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);

    }


}
