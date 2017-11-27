package com.fdworrell.interview.controllers;

import com.fdworrell.interview.converters.IUserConverter;
import com.fdworrell.interview.domains.User;
import com.fdworrell.interview.managers.IUserManager;

import com.fdworrell.interview.views.ViewUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/user")
public class UserControllerV1 {

    @Autowired
    private IUserManager userManager;

    @Autowired
    private IUserConverter userConverter;

    @ApiOperation(value = "Creates a new user")
    @RequestMapping(method = RequestMethod.POST)
    ViewUser register(@RequestBody ViewUser viewUser) {
        User user = userConverter.viewToDomain(viewUser);
        User response = userManager.registerUser(user);
        return userConverter.domainToView(response);
    }

    @ApiOperation(value = "Gets a list of all users of the application")
    @RequestMapping(method = RequestMethod.GET)
    List<ViewUser> getAllUsers() {
        return userManager.getAllUsers().stream()
                .map(userConverter::domainToView)
                .collect(Collectors.toList());
    }

    @ApiOperation(value = "Gets a user by user name")
    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    ViewUser getUserByUserName(@PathVariable String userName) {
        return userConverter.domainToView(userManager.getUserByUserName(userName));
    }
}
