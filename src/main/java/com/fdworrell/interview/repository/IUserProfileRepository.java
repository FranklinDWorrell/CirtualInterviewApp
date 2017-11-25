package com.fdworrell.interview.repository;

import com.fdworrell.interview.domains.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserProfileRepository extends JpaRepository<UserProfile, String> {
    /* No special methods needed. */
}
