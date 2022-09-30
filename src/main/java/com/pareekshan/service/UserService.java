package com.pareekshan.service;

import com.pareekshan.entity.User;
import com.pareekshan.entity.UserRole;

import java.util.Set;

public interface UserService {
    // create User
    public User createUser(User user, Set<UserRole> userRole) throws Exception;
}
