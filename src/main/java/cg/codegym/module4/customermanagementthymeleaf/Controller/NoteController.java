package cg.codegym.module4.customermanagementthymeleaf.Controller;

import cg.codegym.module4.customermanagementthymeleaf.Model.Note;
import cg.codegym.module4.customermanagementthymeleaf.Service.iml.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id){
        Optional<Note> note = noteService.getNoteById(id);
        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Note addNote(@RequestBody Note note) {
        return noteService.addOrUpdateNote(note);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note noteDetails) {
        Optional<Note> note = noteService.getNoteById(id);
        if (note.isPresent()) {
            Note updatedNote = note.get();
            updatedNote.setContent(noteDetails.getContent());
            noteService.addOrUpdateNote(updatedNote);
            return ResponseEntity.ok(updatedNote);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        noteService.deleteNoteById(id);
        return ResponseEntity.noContent().build();
    }
}
