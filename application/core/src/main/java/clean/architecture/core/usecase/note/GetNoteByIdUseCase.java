package clean.architecture.core.usecase.note;

import clean.architecture.core.domain.Note;
import clean.architecture.core.usecase.BaseUseCase;
import lombok.Value;

import java.util.Optional;

public class GetNoteByIdUseCase extends BaseUseCase<GetNoteByIdUseCase.GetNoteByIdInput, GetNoteByIdUseCase.GetNoteByIdOutput> {

    private final NoteRepository noteRepository;

    public GetNoteByIdUseCase(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public GetNoteByIdOutput execute(GetNoteByIdInput input) {
        Optional<Note> note = noteRepository.getNoteById(input.getId());

        return note.map(GetNoteByIdOutput::new).orElseThrow(NullPointerException::new);
    }

    @Value
    public static class GetNoteByIdInput implements InputValues {
        private Long id;
    }

    @Value
    public static class GetNoteByIdOutput implements OutputValues {
        private Note note;
    }
}
