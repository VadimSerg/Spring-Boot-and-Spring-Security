package com.example.bootstudy.service;

import com.example.bootstudy.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> getAll();

    User getUserById(long id);

    void update(User user);

    void deleteUserById(long id);


}