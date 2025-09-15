package com.sanjiban.restapi.service.Impl;

import com.sanjiban.restapi.dto.LoginResponseDto;
import com.sanjiban.restapi.dto.SignupDto;
import com.sanjiban.restapi.dto.UserDetailsDto;
import com.sanjiban.restapi.entities.User;
import com.sanjiban.restapi.respository.UserRepository;
import com.sanjiban.restapi.security.AuthUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthUtil authUtil;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthUtil authUtil, UserRepository userRepository, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.authUtil = authUtil;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }


    public Object signupUser(UserDetailsDto userDetailsDto) {
        User user=userRepository.findByUsername(userDetailsDto.getUsername()).orElse(null);

        if(user!=null){
            throw new IllegalArgumentException("User already exists");
        }

        user=userRepository.save(User.builder()
                .username(userDetailsDto.getUsername())
                .password(passwordEncoder.encode(userDetailsDto.getPassword()))
                .build()
        );

        return new SignupDto(user.getId(),user.getUsername());
    }

    public Object loginUser(UserDetailsDto userDetailsDto) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDetailsDto.getUsername(),userDetailsDto.getPassword())
        );

        User user=(User) authentication.getPrincipal();

        String token= authUtil.generateAccessToken(user);

        return new LoginResponseDto(token,user.getId());
    }
}
