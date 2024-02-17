package com.example.furreverrfinds_backend1.service.impl;

import com.example.furreverrfinds_backend1.dto.AuthenticateRequest;
import com.example.furreverrfinds_backend1.dto.AuthenticateResponse;
import com.example.furreverrfinds_backend1.entity.User;
import com.example.furreverrfinds_backend1.repository.UserRepo;
import com.example.furreverrfinds_backend1.security.JwtService;
import com.example.furreverrfinds_backend1.service.AuthenticateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl implements AuthenticateService {

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    @Override
    public AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticateRequest.getUsername(), authenticateRequest.getPassword()
                )
        );

        User user = userRepo.getUserByUsername(authenticateRequest.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
        UserDetails userDetails = user;
        String jwtToken = jwtService.generateToken(userDetails);


        return AuthenticateResponse
                .builder()
                .token(jwtToken)
                .userId(user.getId())
                .role(user.getId()==3?"admin":"")
                .build();
    }
}
