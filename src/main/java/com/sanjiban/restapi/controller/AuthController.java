package com.sanjiban.restapi.controller;

import com.sanjiban.restapi.dto.SignupDto;
import com.sanjiban.restapi.dto.UserDetailsDto;
import com.sanjiban.restapi.entities.User;
import com.sanjiban.restapi.service.Impl.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody UserDetailsDto userDetailsDto){
        try{
            return ResponseEntity.ok(authService.signupUser(userDetailsDto));
        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDetailsDto userDetailsDto){
        try{
            return ResponseEntity.ok(authService.loginUser(userDetailsDto));
        }catch(Exception ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.FORBIDDEN);
        }
    }
}
