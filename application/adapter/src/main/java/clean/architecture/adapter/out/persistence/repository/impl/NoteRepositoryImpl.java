package clean.architecture.adapter.out.persistence.repository.impl;

import clean.architecture.adapter.out.persistence.entity.NoteTbl;
import clean.architecture.adapter.mapper.NoteMapper;
import clean.architecture.adapter.out.persistence.repository.jpa.JpaNoteRepository;
import clean.architecture.core.domain.Note;
import clean.architecture.core.usecase.note.NoteRepository;

import java.util.List;
import java.util.Optional;

public class NoteRepositoryImpl implements NoteRepository {

    private final JpaNoteRepository jpaNoteRepository;
    private final NoteMapper noteMapper;

    public NoteRepositoryImpl(JpaNoteRepository jpaNoteRepository, NoteMapper noteMapper ) {
        this.jpaNoteRepository = jpaNoteRepository;
        this.noteMapper = noteMapper;
    }

    @Override
    public List<Note> getAllNote() {
        return noteMapper.noteTblToNoteList(jpaNoteRepository.findAll());
    }

    @Override
    public Optional<Note> getNoteById(Long id) {
        return Optional.ofNullable(noteMapper.noteTblToNote(jpaNoteRepository.findById(id).orElse(null)));
    }

    @Override
    public Note save(Note note) {

        NoteTbl noteTbl = new NoteTbl();
        noteTbl.setBody(note.getBody());
        noteTbl.setDone(note.isDone());

        return noteMapper.noteTblToNote(jpaNoteRepository.save(noteTbl));
    }
}
