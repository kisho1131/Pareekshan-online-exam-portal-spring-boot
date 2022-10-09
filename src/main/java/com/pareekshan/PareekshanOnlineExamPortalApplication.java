package com.pareekshan;

import com.pareekshan.entity.Role;
import com.pareekshan.entity.User;
import com.pareekshan.entity.UserRole;
import com.pareekshan.repository.UserRepository;
import com.pareekshan.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class PareekshanOnlineExamPortalApplication {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(PareekshanOnlineExamPortalApplication.class, args);
    }

    /*
    @PostConstruct
    public void saveAdminUser() throws Exception {
        User user = new User();
        user.setFirstName("Sumit");
        user.setLastName("Kumar");
        user.setPhone("7882568408");
        user.setPassword(bCryptPasswordEncoder.encode("admin"));
        user.setEnabled(true);
        user.setUserName("admin");
        user.setProfile("profile Image");
        user.setEmail("admin@mail.com");

        Role role = new Role();
        role.setRoleId(44L);
        role.setRoleName("ADMIN");
        Set<UserRole> userRoleSet = new HashSet<>();
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoleSet.add(userRole);
        User user1 = this.userServiceImpl.createUser(user, userRoleSet);
        this.userRepository.save(user1);
    }
     */


    /*
    public void run(String... args) throws Exception {
        System.out.println("Debug mode....");
        User user = new User();
        user.setFirstName("sumit");
        user.setLastName("kumar");
        user.setPhone("903612122");
        user.setPassword("admin");
        user.setEnabled(true);
        user.setUserName("admin");
        user.setUserName("admin@admin.com");
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
