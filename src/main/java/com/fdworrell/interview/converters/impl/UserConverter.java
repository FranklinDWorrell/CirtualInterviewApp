package com.fdworrell.interview.converters.impl;

import com.fdworrell.interview.converters.IUserConverter;
import com.fdworrell.interview.domains.User;
import com.fdworrell.interview.views.ViewUser;

import org.springframework.stereotype.Service;

@Service
public class UserConverter implements IUserConverter {

    @Override
    public User viewToDomain(ViewUser viewUser) {
        User user = new User();
        user.setUserName(viewUser.getUserName());
        return user;
    }

    @Override
    public ViewUser domainToView(User user) {
        ViewUser viewUser = new ViewUser();
        viewUser.setUserName(user.getUserName());
        return viewUser;
    }

}
