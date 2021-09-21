package clean.architecture.presenter.api.rest;

import clean.architecture.adapter.in.web.controller.CreateNoteResource;
import clean.architecture.adapter.in.web.entity.request.CreatingNoteRequest;
import clean.architecture.adapter.in.web.entity.response.CreatingNoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class CreateNoteController {
    private final CreateNoteResource createNoteResource;


    @PostMapping("/api/note")
    public CreatingNoteResponse createNote(
            @Valid @RequestBody CreatingNoteRequest request) {
        return createNoteResource.exec(request);
    }
}
