package com.nekipelov.crudboot.dao;

import com.nekipelov.crudboot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void createUser(User user);

    User readUser(long id);

    void updateUser(User user, Long id);

    void deleteUser(long id);
}
