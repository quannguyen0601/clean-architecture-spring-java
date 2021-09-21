package clean.architecture.adapter.in.web.controller;

import clean.architecture.adapter.in.web.entity.request.CreatingNoteRequest;
import clean.architecture.adapter.in.web.entity.response.CreatingNoteResponse;
import clean.architecture.adapter.mapper.NoteMapper;
import clean.architecture.core.usecase.note.CreateNoteUseCase;

public class CreateNoteResource implements BaseResource<CreatingNoteRequest, CreatingNoteResponse> {

    private final CreateNoteUseCase createNoteUseCase;
    private final NoteMapper noteMapper;

    public CreateNoteResource(CreateNoteUseCase createNoteUseCase, NoteMapper noteMapper) {
        this.createNoteUseCase = createNoteUseCase;
        this.noteMapper = noteMapper;
    }

    @Override
    public CreatingNoteResponse exec(CreatingNoteRequest request) {
        CreateNoteUseCase.Input input = noteMapper.fromRequestToCreateNoteInput(request);
        CreateNoteUseCase.Output output = createNoteUseCase.execute(input);
        return noteMapper.fromCreatingNoteOutputToResponse(output);
    }


}
