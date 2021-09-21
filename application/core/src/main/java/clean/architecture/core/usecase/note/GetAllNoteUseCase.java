package clean.architecture.core.usecase.note;

import clean.architecture.core.domain.Note;
import clean.architecture.core.usecase.BaseUseCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.util.List;

public class GetAllNoteUseCase extends BaseUseCase<GetAllNoteUseCase.Input, GetAllNoteUseCase.Output> {

    private final NoteRepository noteRepository;

    public GetAllNoteUseCase(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Output execute(Input input) {
        return new Output(noteRepository.getAllNote());
    }

    @Value
    public static class Input implements BaseUseCase.InputValues {
    }

    @Value
    public static class Output implements BaseUseCase.OutputValues {
       List<Note> notes;
    }
}
