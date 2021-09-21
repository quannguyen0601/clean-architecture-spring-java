package clean.architecture.adapter.mapper;

import clean.architecture.adapter.in.web.entity.NoteDto;
import clean.architecture.adapter.in.web.entity.request.CreatingNoteRequest;
import clean.architecture.adapter.in.web.entity.response.CreatingNoteResponse;
import clean.architecture.adapter.in.web.entity.response.GetAllNoteResponse;
import clean.architecture.adapter.out.persistence.entity.NoteTbl;
import clean.architecture.core.domain.Note;
import clean.architecture.core.usecase.note.CreateNoteUseCase;
import clean.architecture.core.usecase.note.GetAllNoteUseCase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface NoteMapper {

    @Mapping(target = "user",ignore = true)
    Note noteTblToNote(NoteTbl noteTbl);

    List<Note> noteTblToNoteList(List<NoteTbl> noteTbls);

    NoteDto fromNoteToNoteDto(Note note);

    List<NoteDto> fromNoteToNoteDto(List<Note> note);

    // Creating Note Request
    CreateNoteUseCase.Input fromRequestToCreateNoteInput(CreatingNoteRequest createNoteRequest);
    CreatingNoteResponse fromCreatingNoteOutputToResponse(CreateNoteUseCase.Output note);

    //GetAllNoteUseCase
    GetAllNoteResponse fromGetAllNoteOutputToResponse(GetAllNoteUseCase.Output note);
}

