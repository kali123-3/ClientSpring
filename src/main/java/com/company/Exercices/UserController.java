package com.company.Exercices;

import com.company.Exercices.config.security.MyAuthentificationProvider;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "User", description = "Managemet of user of application ")
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
    private MyAuthentificationProvider myAuthentificationProvider;


    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {

        try {
            myAuthentificationProvider.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            return "Authenticated successfully!"; // Return token or user info as needed

        }catch (BadCredentialsException e) {
            return "NON AUTHENTICATED";
        }

    }
    // POST /logout: Handle logout requests
    @PostMapping("/logout")
    public String logout() {
        return "Logout successful!";
    }
}
