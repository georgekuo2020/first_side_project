package com.example.BackendService.services;

import com.example.BackendService.model.User;

import java.util.List;

public interface IUserService {

    List<User> findUserListByIsNotDeleted();

    User findById(String id);

    boolean checkIfUserEmailExist(String email);

    void save(User user);

    void deleteUser(User user);
}
