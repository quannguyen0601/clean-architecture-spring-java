package clean.architecture.adapter.mapper;

import clean.architecture.adapter.in.web.entity.request.CreatingNoteRequest;
import clean.architecture.adapter.in.web.entity.response.CreatingNoteResponse;
import clean.architecture.adapter.in.web.entity.response.GetAllNoteResponse;
import clean.architecture.adapter.out.persistence.entity.NoteTbl;
import clean.architecture.adapter.out.persistence.entity.UserTbl;
import clean.architecture.core.domain.Note;
import clean.architecture.core.domain.User;
import clean.architecture.core.usecase.note.CreateNoteUseCase;
import clean.architecture.core.usecase.note.GetAllNoteUseCase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "notes", ignore = true)
    User userTblToUser(UserTbl userTbl);

    @Mapping(target = "notes", ignore = true)
    Optional<User> userTblToUser(Optional<UserTbl> userTbl);

    List<User> userTblToUserList(List<UserTbl> userTblList);

    UserTbl userToUserTbl(User user);
}

