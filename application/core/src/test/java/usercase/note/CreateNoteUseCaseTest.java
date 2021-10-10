package usercase.note;

import clean.architecture.core.domain.Note;
import clean.architecture.core.domain.User;
import clean.architecture.core.usecase.note.CreateNoteUseCase;
import clean.architecture.core.usecase.note.NoteRepository;
import clean.architecture.core.usecase.user.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateNoteUseCaseTest {

    @Mock
    private  NoteRepository noteRepository;

    @Mock
    private  UserRepository userRepository;

    @InjectMocks
    private  CreateNoteUseCase createNoteUseCase;

    private final CreateNoteUseCase.Input input = new CreateNoteUseCase.Input("Test Body", false, 1L);
    private final User user = new User(1L,"Username","test@gmail.com","password", List.of());
    private final Note noteBefore  = new Note(null,input.getBody(),input.isDone(), user);
    private final Note savedNote = new Note(1L,input.getBody(),input.isDone(), user);;

    @Test
    @DisplayName("whenCreateNewNoteThenReturnCreatedNote")
    void whenCreateNewNoteThenCallingNoteRepositorySave() {

        //MOCK
        when(userRepository.findUserById(input.getUserId())).thenReturn(Optional.of(user));

        //DO
        createNoteUseCase.execute(input);

        //VERIFY
        verify(noteRepository, times(1)).save(noteBefore);
    }


    @Test
    void whenCreateNewNoteThenReturnNewNode() {
        //MOCK
        when(userRepository.findUserById(input.getUserId())).thenReturn(Optional.of(user));
        when(noteRepository.save(noteBefore)).thenReturn(savedNote);

        //DO
        CreateNoteUseCase.Output output = createNoteUseCase.execute(input);

        //VERIFY
        assertEquals(savedNote, output.getNote());
    }

    @Test
    void whenCreateNewNoteThenThrowNullPointerException() {

        when(userRepository.findUserById(input.getUserId())).thenReturn(Optional.empty());

        //DO
        Exception exception = assertThrows(NullPointerException.class, () -> createNoteUseCase.execute(input));

        //VERIFY
        assertNull(exception.getMessage());
    }
}
