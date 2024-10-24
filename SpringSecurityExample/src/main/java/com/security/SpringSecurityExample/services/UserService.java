package com.security.SpringSecurityExample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.SpringSecurityExample.model.Users;
import com.security.SpringSecurityExample.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users user) {
        // password encrypt
        user.setPassword( encoder.encode(user.getPassword()) );

        return userRepo.save(user);
    }

    public String verify() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verify'");
    }

    public String verify(Users user) {
        Authentication authentication = 
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        if (authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        return "Fail";
    }


}
