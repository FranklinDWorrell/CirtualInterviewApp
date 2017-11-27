package com.fdworrell.interview.converters;

import com.fdworrell.interview.domains.User;
import com.fdworrell.interview.views.ViewUser;

public interface IUserConverter {

    User viewToDomain(ViewUser viewUser);

    ViewUser domainToView(User user);

}
