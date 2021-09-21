package clean.architecture.adapter.in.web.entity.response;

import clean.architecture.adapter.in.web.entity.NoteDto;
import lombok.Data;

@Data
public class CreatingNoteResponse {
    private NoteDto note;
}
