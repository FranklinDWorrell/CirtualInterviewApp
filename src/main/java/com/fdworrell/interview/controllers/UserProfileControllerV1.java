package com.fdworrell.interview.controllers;

import com.fdworrell.interview.converters.IUserProfileConverter;
import com.fdworrell.interview.domains.UserProfile;
import com.fdworrell.interview.managers.IUserProfileManager;
import com.fdworrell.interview.views.ViewUserProfile;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/userProfile")
public class UserProfileControllerV1 {

    @Autowired
    private IUserProfileManager userProfileManager;

    @Autowired
    private IUserProfileConverter userProfileConverter;

    @ApiOperation(value = "Get a user's profile by user name")
    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    ViewUserProfile getUserProfileByUserName(@PathVariable String userName) {
        UserProfile profile = userProfileManager.getUserProfileByUserName(userName);
        if (profile == null) {
            return null;
        }
        return userProfileConverter.domainToView(profile);
    }

    @ApiOperation(value = "Creates a new profile for a user")
    @RequestMapping(method = RequestMethod.POST)
    ViewUserProfile createUserProfile(@RequestBody ViewUserProfile viewUserProfile) {
        UserProfile userProfile = userProfileConverter.viewToDomain(viewUserProfile);
        UserProfile profile = userProfileManager.createUserProfile(userProfile);
        return userProfileConverter.domainToView(profile);
    }

    @ApiOperation(value = "Updates a user's current profile")
    @RequestMapping(method = RequestMethod.PUT)
    ViewUserProfile updateUserProfile(@RequestBody ViewUserProfile viewUserProfile) {
        UserProfile userProfile = userProfileConverter.viewToDomain(viewUserProfile);
        UserProfile profile = userProfileManager.updateUserProfile(userProfile.getUserName(), userProfile);
        return userProfileConverter.domainToView(profile);
    }

    @ApiOperation(value = "Delete a user's profile")
    @RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
    ViewUserProfile deleteUserProfileByUserName(@PathVariable String userName) {
        UserProfile profile = userProfileManager.deleteUserProfile(userName);
        return userProfileConverter.domainToView(profile);
    }

}
