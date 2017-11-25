package com.fdworrell.interview.repository;

import com.fdworrell.interview.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {
    /* No special methods required. */
}
