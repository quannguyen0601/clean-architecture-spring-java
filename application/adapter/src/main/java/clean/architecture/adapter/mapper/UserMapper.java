package clean.architecture.adapter.mapper;

import clean.architecture.adapter.in.web.entity.UserDto;
import clean.architecture.adapter.out.persistence.entity.UserTbl;
import clean.architecture.core.domain.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "notes", ignore = true)
    User userTblToUser(UserTbl userTbl);

    UserDto fromUserToUserDto(User user);

    List<User> userTblToUserList(List<UserTbl> userTblList);

    UserTbl userToUserTbl(User user);
}

