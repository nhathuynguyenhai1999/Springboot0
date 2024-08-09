package cg.codegym.module4.customermanagementthymeleaf.Service.iml;

import cg.codegym.module4.customermanagementthymeleaf.Model.Note;
import cg.codegym.module4.customermanagementthymeleaf.Repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note addOrUpdateNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }
}
