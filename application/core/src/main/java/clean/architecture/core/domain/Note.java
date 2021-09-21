package clean.architecture.core.domain;


import java.util.Objects;

public class Note extends BaseEntity {
    private Long id;

    private String body;

    private boolean done;

    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return done == note.done && Objects.equals(id, note.id) && Objects.equals(body, note.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, body, done);
    }
}
