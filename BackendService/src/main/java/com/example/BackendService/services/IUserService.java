package com.example.BackendService.services;

import com.example.BackendService.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
}
