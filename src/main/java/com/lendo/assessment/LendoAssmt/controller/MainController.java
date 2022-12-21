package com.lendo.assessment.LendoAssmt.controller;

import com.lendo.assessment.LendoAssmt.JWTUtilPackage.JwtUtil;
import com.lendo.assessment.LendoAssmt.model.AuthenticationRequest;
import com.lendo.assessment.LendoAssmt.model.AuthenticationResponse;
import com.lendo.assessment.LendoAssmt.model.CustomResponse;
import com.lendo.assessment.LendoAssmt.model.User;
import com.lendo.assessment.LendoAssmt.services.MyUserDetailsService;
import com.lendo.assessment.LendoAssmt.services.mainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("lendo/api/")
public class MainController {

    @Autowired
    mainService mainService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;


    @PostMapping(value = "authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception
    {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        }
        catch(BadCredentialsException e)
        {
            throw new Exception("Incorrect Username or Password",e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @PostMapping(value = "addUser")
    public CustomResponse addUser(@RequestBody User user)
    {
        return mainService.addUser(user);
    }

    @PostMapping(value = "addAllUser")
    public CustomResponse addUser(@RequestBody List<User> users)
    {
        return mainService.addAllUser(users);
    }

    @GetMapping(value = "getAllUser")
    public CustomResponse getAllUser()
    {
        return mainService.getAllUser();
    }
}
