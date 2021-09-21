package clean.architecture.adapter.in.web.entity.request;

import lombok.Data;

@Data
public class CreatingNoteRequest {
    private String body;
    private boolean done;
    private Long userId;
}
