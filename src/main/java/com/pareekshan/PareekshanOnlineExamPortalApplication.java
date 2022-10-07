package com.pareekshan;

import com.pareekshan.entity.Role;
import com.pareekshan.entity.User;
import com.pareekshan.entity.UserRole;
import com.pareekshan.service.UserService;
import com.pareekshan.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class PareekshanOnlineExamPortalApplication {

    @Autowired
    private UserServiceImpl userServiceImpl;

    public static void main(String[] args) {
        SpringApplication.run(PareekshanOnlineExamPortalApplication.class, args);
    }

    /*
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Debug mode....");
        User user = new User();
        user.setFirstName("sumit");
        user.setLastName("kumar");
        user.setPhone("903612122");
        user.setPassword("password");
        user.setEnabled(true);
        user.setUserName("sumit");
        user.setUserName("sumit@gmail.com");
        user.setProfile("profile Image");

        Role role = new Role();
        role.setRoleId(44L);
        role.setRoleName("ADMIN");
        Set<UserRole> userRoleSet = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoleSet.add(userRole);

        User user1 = this.userServiceImpl.createUser(user, userRoleSet);
        System.out.println(user1.getUserName() + user1.getFirstName());

    }
     */
}
