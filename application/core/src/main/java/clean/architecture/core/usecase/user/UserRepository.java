package clean.architecture.core.usecase.user;

import clean.architecture.core.domain.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findUserById(Long id);
}
