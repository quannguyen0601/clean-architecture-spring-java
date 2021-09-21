package clean.architecture.presenter.configuration.module;

import clean.architecture.adapter.mapper.NoteMapper;
import clean.architecture.adapter.mapper.UserMapper;
import clean.architecture.adapter.out.persistence.repository.impl.NoteRepositoryImpl;
import clean.architecture.adapter.out.persistence.repository.impl.UserRepositoryImpl;
import clean.architecture.adapter.out.persistence.repository.jpa.JpaNoteRepository;
import clean.architecture.adapter.out.persistence.repository.jpa.JpaUserRepository;
import clean.architecture.core.usecase.note.CreateNoteUseCase;
import clean.architecture.core.usecase.note.GetAllNoteUseCase;
import clean.architecture.core.usecase.note.NoteRepository;
import clean.architecture.core.usecase.user.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModuleConfiguration {

    @Bean
    UserRepository userRepository(JpaUserRepository jpaUserRepository, UserMapper userMapper) {
        return new UserRepositoryImpl(jpaUserRepository, userMapper);
    }

    @Bean
    NoteRepository noteRepository(JpaNoteRepository jpaNoteRepository, NoteMapper noteMapper) {
        return new NoteRepositoryImpl(jpaNoteRepository, noteMapper);
    }

    @Bean
    CreateNoteUseCase createNoteUseCase(NoteRepository noteRepository, UserRepository userRepository) {
        return new CreateNoteUseCase(noteRepository, userRepository);
    }

    @Bean
    GetAllNoteUseCase createGetAllNoteUseCase(NoteRepository noteRepository) {
        return new GetAllNoteUseCase(noteRepository);
    }
}
