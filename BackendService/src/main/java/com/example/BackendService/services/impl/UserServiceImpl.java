package com.example.BackendService.services.impl;

import com.example.BackendService.model.User;
import com.example.BackendService.repository.UserRepository;
import com.example.BackendService.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> findUserListByIsNotDeleted() {
        return userRepository.findUserListByIsNotDeleted();
    }

    @Override
    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public boolean checkIfUserEmailExist(String email) {
        User user = userRepository.findByEmail(email.toLowerCase());
        return user != null;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        user.setIsDelete(1);
        this.save(user);
    }
}
