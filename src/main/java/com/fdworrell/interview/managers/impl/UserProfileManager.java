package com.fdworrell.interview.managers.impl;

import com.fdworrell.interview.domains.UserProfile;
import com.fdworrell.interview.managers.IUserProfileManager;
import com.fdworrell.interview.repository.IUserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class UserProfileManager implements IUserProfileManager {

    @Autowired
    private IUserProfileRepository userProfileRepository;

    @Override
    public UserProfile getUserProfileByUserName(String userName) {
        return userProfileRepository.findById(userName).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public UserProfile createUserProfile(UserProfile userProfile) {
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile updateUserProfile(String userName, UserProfile userProfile) {
        UserProfile currentProfile = userProfileRepository.findById(userName).orElse(null);
        if (currentProfile == null || userProfile.getUserName() != userName) {
            return null;
        }
        return userProfileRepository.save(userProfile);
    }

    @Override
    public UserProfile deleteUserProfile(String userName) {
        UserProfile profile = userProfileRepository.findById(userName).orElse(null);
        if (profile == null) {
            return null;
        }
        userProfileRepository.delete(profile);
        return profile;
    }

}
