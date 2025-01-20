package com.company.Exercices;

import com.company.Exercices.config.security.MyAuthentificationProvider;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User", description = "Managemet of user of application ")
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
    private MyAuthentificationProvider myAuthentificationProvider;


    @PostMapping("/login")
    public HttpStatus login(@RequestBody LoginRequest loginRequest) {

        try {
            myAuthentificationProvider.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            return HttpStatus.OK; // Return token or user info as needed

        }catch (BadCredentialsException e) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
    // POST /logout: Handle logout requests
    @PostMapping("/logout")
    public String logout() {
        return "Logout successful!";
    }
}
