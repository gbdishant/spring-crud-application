package com.springcrud.user;

import com.springcrud.dto.User;
import java.util.List;

public interface UserEntityService {

    User createUser(User user);

    User getUserById(Integer userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Integer userId);
}
