package com.pareekshan.controllers;

import com.pareekshan.entity.Role;
import com.pareekshan.entity.User;
import com.pareekshan.entity.UserRole;
import com.pareekshan.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/v1.0/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /* Register the user to the Database */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) throws Exception {
        if(user.getProfile() == null){
            user.setProfile("default User Profile");
        }
        Set<UserRole> userRoles = new HashSet<>();
        Role role = new Role();
        role.setRoleId(45L);
        role.setRoleName("NORMAL");
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(role);
        userRoles.add(userRole);
        return this.userService.createUser(user, userRoles);
    }

    /* Get the User from the Database based on user_id */
    @RequestMapping(value = "/get/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable("username") String username) throws Exception {
        User user = this.userService.getUser(username);
        if(user == null){
            System.out.println("User with " + username + " dosen't exist");
            throw new Exception("User with " + username + " dosen't exist");
        }else
            return user;
    }

    /* Delete the user from the Database */
    @RequestMapping(value = "delete/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable ("username") String username) throws Exception {
        User user = this.userService.deleteUser(username);
        return ResponseEntity.ok(user);
    }
}
