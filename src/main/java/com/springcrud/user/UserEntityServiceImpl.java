package com.springcrud.user;

import com.springcrud.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserEntityServiceImpl implements UserEntityService {

    private final UserEntityRepository userEntityRepository;
    private final UserEntityTransformer userEntityTransformer;

    @Override
    public User createUser(User user) {
        UserEntity entity = userEntityTransformer.toEntity(user, new UserEntity());
        entity = userEntityRepository.save(entity);
        user = userEntityTransformer.fromEntity(entity);
        return user;
    }

    @Override
    public User getUserById(Integer userId) {
        Optional<UserEntity> optionalUser = userEntityRepository.findById(userId);
        return userEntityTransformer.fromEntity(optionalUser.get());
    }

    @Override
    public List<User> getAllUsers() {
        return userEntityRepository.findAll().stream().map(userEntityTransformer::fromEntity).collect(Collectors.toList());
    }

    @Override
    public User updateUser(User user) {
        Optional<UserEntity> optionalUserEntity = userEntityRepository.findById(user.getId());

        UserEntity userEntity = optionalUserEntity.get();
        userEntity.setId(user.getId());
        userEntity = userEntityTransformer.toEntity(user, userEntity);
        UserEntity updatedUser = userEntityRepository.save(userEntity);
        return userEntityTransformer.fromEntity(updatedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        userEntityRepository.deleteById(userId);
    }
}
