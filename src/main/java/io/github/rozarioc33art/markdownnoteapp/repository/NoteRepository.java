package io.github.rozarioc33art.markdownnoteapp.repository;

import io.github.rozarioc33art.markdownnoteapp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
