package com.fdworrell.interview.converters;

import com.fdworrell.interview.domains.UserProfile;
import com.fdworrell.interview.views.ViewUserProfile;

public interface IUserProfileConverter {

    UserProfile viewToDomain(ViewUserProfile viewUserProfile);

    ViewUserProfile domainToView(UserProfile userProfile);

}
