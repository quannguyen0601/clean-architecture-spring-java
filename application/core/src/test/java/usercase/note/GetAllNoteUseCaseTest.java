package usercase.note;

import clean.architecture.core.domain.Note;
import clean.architecture.core.domain.User;
import clean.architecture.core.usecase.note.CreateNoteUseCase;
import clean.architecture.core.usecase.note.GetAllNoteUseCase;
import clean.architecture.core.usecase.note.NoteRepository;
import clean.architecture.core.usecase.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllNoteUseCaseTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private GetAllNoteUseCase getAllNoteUseCase;

    private final User user = new User(1L,"Username","test@gmail.com","password", List.of());
    private final Note note1  = new Note(1L,"body1",false, user);
    private final Note note2  = new Note(2L,"body2",false, user);
    private final Note note3  = new Note(3L,"body3",false, user);

    @Test
    void whenGetAllNotesThenReturnAllNotes() {
        List<Note> notes = List.of(note1,note2,note3);

        when(noteRepository.getAllNote()).thenReturn(notes);

        //DO
        GetAllNoteUseCase.Output output = getAllNoteUseCase.execute(new GetAllNoteUseCase.Input());

        //VERIFY
        assertEquals(notes.size(),output.getNotes().size());
    }
}
