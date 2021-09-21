package clean.architecture.adapter.in.web.controller;

import clean.architecture.adapter.in.web.entity.request.CreatingNoteRequest;
import clean.architecture.adapter.in.web.entity.response.CreatingNoteResponse;
import clean.architecture.adapter.in.web.entity.response.GetAllNoteResponse;
import clean.architecture.adapter.mapper.NoteMapper;
import clean.architecture.core.usecase.note.GetAllNoteUseCase;

public class GetAllNoteResource implements BaseResource<Void, GetAllNoteResponse> {

    private final GetAllNoteUseCase GetAllNoteUseCase;
    private final NoteMapper noteMapper;

    public GetAllNoteResource(GetAllNoteUseCase GetAllNoteUseCase, NoteMapper noteMapper) {
        this.GetAllNoteUseCase = GetAllNoteUseCase;
        this.noteMapper = noteMapper;
    }

    @Override
    public GetAllNoteResponse exec(Void input) {
        GetAllNoteUseCase.Output output = GetAllNoteUseCase.execute(new GetAllNoteUseCase.Input());
        return noteMapper.fromGetAllNoteOutputToResponse(output);
    }
}
