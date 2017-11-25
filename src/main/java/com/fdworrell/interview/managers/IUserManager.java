package com.fdworrell.interview.managers;

import com.fdworrell.interview.domains.User;

import java.util.List;

public interface IUserManager {

    public List<User> getAllUsers();

    public User getUserByUserName(String userName);

    public User registerUser(User user);

}
