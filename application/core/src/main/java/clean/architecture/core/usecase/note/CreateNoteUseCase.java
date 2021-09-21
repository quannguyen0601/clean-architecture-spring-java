package clean.architecture.core.usecase.note;

import clean.architecture.core.domain.Note;
import clean.architecture.core.domain.User;
import clean.architecture.core.usecase.BaseUseCase;
import clean.architecture.core.usecase.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.util.Optional;

public class CreateNoteUseCase extends BaseUseCase<CreateNoteUseCase.Input, CreateNoteUseCase.Output> {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    public CreateNoteUseCase(NoteRepository noteRepository, UserRepository userRepository) {

        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Output execute(Input input) {
        Note note = new Note();
        note.setBody(input.getBody());
        note.setDone(input.isDone());

        User user = userRepository.findUserById(input.getUserId()).orElseThrow(NullPointerException::new);

        note.setUser(user);

        return new Output(noteRepository.save(note));
    }

    @Value
    public static class Input implements InputValues {
        String body;
        boolean done;
        Long userId;
    }

    @Value
    public static class Output implements OutputValues {
        Note note;
    }
}
