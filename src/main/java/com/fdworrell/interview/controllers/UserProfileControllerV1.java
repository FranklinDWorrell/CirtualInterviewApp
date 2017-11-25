package com.fdworrell.interview.controllers;

import com.fdworrell.interview.domains.UserProfile;
import com.fdworrell.interview.managers.IUserProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/userProfile")
public class UserProfileControllerV1 {

    @Autowired
    private IUserProfileManager userProfileManager;

    @RequestMapping(value = "/{userName}", method = RequestMethod.GET)
    UserProfile getUserProfileByUserName(@PathVariable String userName) {
        return userProfileManager.getUserProfileByUserName(userName);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile profile = userProfileManager.createUserProfile(userProfile);
        return new ResponseEntity<UserProfile>(profile, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile userProfile) {
        UserProfile profile = userProfileManager.updateUserProfile(userProfile.getUserName(), userProfile);
        if (profile == null) {
            return new ResponseEntity<UserProfile>(profile, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserProfile>(profile, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userName}", method = RequestMethod.DELETE)
    UserProfile deleteUserProfileByUserName(@PathVariable String userName) {
        return userProfileManager.deleteUserProfile(userName);
    }
}
