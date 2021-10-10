package usercase.note;

import clean.architecture.core.domain.Note;
import clean.architecture.core.domain.User;
import clean.architecture.core.usecase.note.GetNoteByIdUseCase;
import clean.architecture.core.usecase.note.NoteRepository;
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
class GetNoteByIdUseCaseTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private GetNoteByIdUseCase getNoteByIdUseCase;

    private final User user = new User(1L,"Username","test@gmail.com","password", List.of());
    private final Note note1  = new Note(1L,"body1",false, user);

    @Test
    void whenGetNoteByIdUseCaseThenReturnNote() {
        GetNoteByIdUseCase.GetNoteByIdInput input = new GetNoteByIdUseCase.GetNoteByIdInput(note1.getId());

        when(noteRepository.getNoteById(input.getId())).thenReturn(Optional.of(note1));

        GetNoteByIdUseCase.GetNoteByIdOutput output = getNoteByIdUseCase.execute(input);

        assertEquals(note1,output.getNote());
    }

    @Test
    void whenGetNoteByNullIdThenThrowNull() {
        GetNoteByIdUseCase.GetNoteByIdInput input = new GetNoteByIdUseCase.GetNoteByIdInput(note1.getId());

        when(noteRepository.getNoteById(input.getId())).thenReturn(Optional.empty());

        Exception exception = assertThrows(NullPointerException.class, () -> getNoteByIdUseCase.execute(input));

        assertNull(exception.getMessage());
    }


}
