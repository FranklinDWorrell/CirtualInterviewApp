package com.fdworrell.interview.controllers;

import com.fdworrell.interview.domains.User;
import com.fdworrell.interview.managers.IUserManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserControllerV1 {

    @Autowired
    private IUserManager userManager;

    @RequestMapping(method = RequestMethod.GET)
    List<User> getAllUsers() {
        return userManager.getAllUsers();
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    User getUserByUserName(@PathVariable String userName) {
        return userManager.getUserByUserName(userName);
    }
}
