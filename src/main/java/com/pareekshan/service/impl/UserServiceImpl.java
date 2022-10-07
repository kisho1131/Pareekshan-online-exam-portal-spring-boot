package com.pareekshan.service.impl;

import com.pareekshan.entity.User;
import com.pareekshan.entity.UserRole;
import com.pareekshan.repository.RoleRepository;
import com.pareekshan.repository.UserRepository;
import com.pareekshan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    // creating new user
    @Override
    public User createUser(User user, Set<UserRole> userRole) throws Exception {
        User newUser = this.userRepository.findByUserName(user.getUserName());
        if(newUser != null){
            System.out.println("User with user name already Exist");
            throw new Exception("User already Exist");
        }else {
            for(UserRole role : userRole){
                roleRepository.save(role.getRole());
            }
            user.getUserRole().addAll(userRole);
            newUser = this.userRepository.save(user);
        }
        return newUser;
    }

    // get user by username
    @Override
    public User getUser(String username) {
        return this.userRepository.findByUserName(username);
    }

    @Override
    public User deleteUser(String username) throws Exception {
        User user = this.userRepository.findByUserName(username);
        if(user == null){
            System.out.println("User with " + username + " dosen't exist");
            throw new Exception("User with " + username + " dosen't exist");
        }else {
            this.userRepository.delete(user);
        }
        return user;
    }
}
