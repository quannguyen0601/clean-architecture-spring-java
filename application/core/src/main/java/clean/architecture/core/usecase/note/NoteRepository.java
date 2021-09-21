package clean.architecture.core.usecase.note;

import clean.architecture.core.domain.Note;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {
    List<Note> getAllNote();

    Optional<Note> getNoteById(Long id);

    Note save(Note note);
}
