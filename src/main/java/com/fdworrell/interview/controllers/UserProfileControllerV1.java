package com.fdworrell.interview.controllers;

import com.fdworrell.interview.converters.IUserProfileConverter;
import com.fdworrell.interview.domains.UserProfile;
import com.fdworrell.interview.managers.IUserProfileManager;
import com.fdworrell.interview.views.ViewUserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/userProfile")
public class UserProfileControllerV1 {

    @Autowired
    private IUserProfileManager userProfileManager;

    @Autowired
    private IUserProfileConverter userProfileConverter;

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    ViewUserProfile getUserProfileByUserName(@PathVariable String userName) {
        UserProfile profile = userProfileManager.getUserProfileByUserName(userName);
        return userProfileConverter.domainToView(profile);
    }

    @RequestMapping(method = RequestMethod.POST)
    ViewUserProfile createUserProfile(@RequestBody ViewUserProfile viewUserProfile) {
        UserProfile userProfile = userProfileConverter.viewToDomain(viewUserProfile);
        UserProfile profile = userProfileManager.createUserProfile(userProfile);
        return userProfileConverter.domainToView(profile);
    }

    @RequestMapping(method = RequestMethod.PUT)
    ViewUserProfile updateUserProfile(@RequestBody ViewUserProfile viewUserProfile) {
        UserProfile userProfile = userProfileConverter.viewToDomain(viewUserProfile);
        UserProfile profile = userProfileManager.updateUserProfile(userProfile.getUserName(), userProfile);
        return userProfileConverter.domainToView(profile);
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
    ViewUserProfile deleteUserProfileByUserName(@PathVariable String userName) {
        UserProfile profile = userProfileManager.deleteUserProfile(userName);
        return userProfileConverter.domainToView(profile);
    }

}
