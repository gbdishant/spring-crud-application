package com.springcrud.user;

import com.springcrud.dto.User;
import org.springframework.stereotype.Component;

@Component
public class UserEntityTransformer {

    public UserEntity toEntity(User user, UserEntity userEntity) {

        if (userEntity == null) {
            userEntity = new UserEntity();
        }

        userEntity.setEmail(user.getEmail());
        userEntity.setGender(user.getGender());
        userEntity.setName(user.getName());
        userEntity.setStatus(user.getStatus());
        userEntity.setUserId(user.getUserId());
        return userEntity;
    }

    public User fromEntity(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setGender(userEntity.getGender());
        user.setName(userEntity.getName());
        user.setStatus(userEntity.getStatus());
        user.setUserId(userEntity.getUserId());
        return user;
    }
}
