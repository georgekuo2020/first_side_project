package com.example.BackendService.services.impl;

import com.example.BackendService.model.User;
import com.example.BackendService.repository.UserRepository;
import com.example.BackendService.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
