package com.fdworrell.interview.managers;

import com.fdworrell.interview.domains.UserProfile;

public interface IUserProfileManager {

    UserProfile getUserProfileByUserName(String userName);

    UserProfile createUserProfile(UserProfile userProfile);

    UserProfile updateUserProfile(String userName, UserProfile userProfile);

    UserProfile deleteUserProfile(String userName);

}
