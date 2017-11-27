package com.fdworrell.interview.converters.impl;

import com.fdworrell.interview.converters.IDateLongConverter;
import com.fdworrell.interview.converters.IUserProfileConverter;
import com.fdworrell.interview.domains.UserProfile;
import com.fdworrell.interview.views.ViewUserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileConverter implements IUserProfileConverter {

    @Autowired
    IDateLongConverter dateLongConverter;

    @Override
    public UserProfile viewToDomain(ViewUserProfile viewUserProfile) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUserName(viewUserProfile.getUserName());
        userProfile.setFirstName(viewUserProfile.getFirstName());
        userProfile.setLastName(viewUserProfile.getLastName());
        userProfile.setGender(viewUserProfile.getGender());
        userProfile.setBirthday(dateLongConverter.convertLongToLocalDateTime(viewUserProfile.getBirthday()));
        userProfile.setCity(viewUserProfile.getCity());
        userProfile.setState(viewUserProfile.getState());
        userProfile.setCountry(viewUserProfile.getCountry());
        userProfile.setQuote(viewUserProfile.getQuote());
        return userProfile;
    }

    @Override
    public ViewUserProfile domainToView(UserProfile userProfile) {
        ViewUserProfile viewUserProfile = new ViewUserProfile();
        viewUserProfile.setUserName(userProfile.getUserName());
        viewUserProfile.setFirstName(userProfile.getFirstName());
        viewUserProfile.setLastName(userProfile.getLastName());
        viewUserProfile.setGender(userProfile.getGender());
        viewUserProfile.setBirthday(dateLongConverter.convertLocalDateTimeToLong(userProfile.getBirthday()));
        viewUserProfile.setCity(userProfile.getCity());
        viewUserProfile.setState(userProfile.getState());
        viewUserProfile.setCountry(userProfile.getCountry());
        viewUserProfile.setQuote(userProfile.getQuote());
        return viewUserProfile;
    }

}
