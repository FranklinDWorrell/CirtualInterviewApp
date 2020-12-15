package com.fdworrell.interview.managers.impl;

import com.fdworrell.interview.domains.User;
import com.fdworrell.interview.managers.IUserManager;
import com.fdworrell.interview.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
public class UserManager implements IUserManager {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findById(userName).orElseThrow(EntityNotFoundException::new);
//        return userRepository.findOne(userName);
    }

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

}
