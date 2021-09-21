package clean.architecture.presenter.api.rest;

import clean.architecture.adapter.in.web.controller.GetAllNoteResource;
import clean.architecture.adapter.in.web.entity.response.GetAllNoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetAllNotesController {

    private final GetAllNoteResource getAllNoteResource;

    @GetMapping("/api/notes")
    public GetAllNoteResponse getNotes() {
        return getAllNoteResource.exec(null);
    }
}
