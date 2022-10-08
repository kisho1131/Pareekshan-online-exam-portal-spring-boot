package com.pareekshan.controllers;

import com.pareekshan.entity.JwtRequest;
import com.pareekshan.entity.JwtResponse;
import com.pareekshan.entity.User;
import com.pareekshan.service.impl.UserDetailsServiceImpl;
import com.pareekshan.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtUtils jwtUtils;

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        }catch (DisabledException e){
            System.out.println("USER IS DISABLED");
            throw new Exception("USER DISABLED");
        }catch (BadCredentialsException e){
            throw new Exception("INVALID CREDENTIALS");
        }
    }

    // Generate Token
    @RequestMapping(value = "/generateToken", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest request) throws Exception {
        try {
            authenticate(request.getUsername(), request.getPassword());

        }catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("User with the given Username is not Found !");

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Token Can't be Generated !");
        }
        UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(request.getUsername());
        String token = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    // Return the current logged-in user
    @RequestMapping(value = "/current-user", method = RequestMethod.GET)
    public User getCurrentUser(Principal principal){
       return (User) this.userDetailsServiceImpl.loadUserByUsername(principal.getName());
    }
}
