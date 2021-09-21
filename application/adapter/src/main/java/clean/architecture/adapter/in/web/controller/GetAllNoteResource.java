package clean.architecture.adapter.in.web.controller;

import clean.architecture.adapter.in.web.entity.response.GetAllNoteResponse;
import clean.architecture.adapter.mapper.NoteMapper;
import clean.architecture.core.usecase.note.GetAllNoteUseCase;
import org.springframework.stereotype.Component;

@Component
public class GetAllNoteResource implements BaseResource<Void, GetAllNoteResponse> {

    private final GetAllNoteUseCase getAllNoteUseCase;
    private final NoteMapper noteMapper;

    public GetAllNoteResource(GetAllNoteUseCase getAllNoteUseCase, NoteMapper noteMapper) {
        this.getAllNoteUseCase = getAllNoteUseCase;
        this.noteMapper = noteMapper;
    }

    @Override
    public GetAllNoteResponse exec(Void input) {
        GetAllNoteUseCase.Output output = getAllNoteUseCase.execute(new GetAllNoteUseCase.Input());
        return noteMapper.fromGetAllNoteOutputToResponse(output);
    }
}
