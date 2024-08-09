package cg.codegym.module4.customermanagementthymeleaf.Repository;

import cg.codegym.module4.customermanagementthymeleaf.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
