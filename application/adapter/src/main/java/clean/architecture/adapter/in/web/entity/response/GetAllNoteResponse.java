package clean.architecture.adapter.in.web.entity.response;

import clean.architecture.adapter.in.web.entity.NoteDto;
import lombok.Data;

import java.util.List;

@Data
public class GetAllNoteResponse {
    private List<NoteDto> notes;
}
