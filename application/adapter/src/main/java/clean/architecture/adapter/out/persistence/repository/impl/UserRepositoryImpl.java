package clean.architecture.adapter.out.persistence.repository.impl;

import clean.architecture.adapter.mapper.NoteMapper;
import clean.architecture.adapter.mapper.UserMapper;
import clean.architecture.adapter.out.persistence.repository.jpa.JpaUserRepository;
import clean.architecture.core.domain.User;
import clean.architecture.core.usecase.user.UserRepository;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;
    private final UserMapper userMapper;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository, UserMapper userMapper) {
        this.jpaUserRepository = jpaUserRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return Optional.ofNullable(userMapper.userTblToUser(jpaUserRepository.findById(id).orElse(null)));
    }
}
