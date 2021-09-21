package clean.architecture.adapter.in.web.entity;

import lombok.Data;


@Data
public class NoteDto {
    private Long id;
    private String body;
    private boolean done;
    private UserDto user;
}
