package com.example.furreverrfinds_backend1.service;

import com.example.furreverrfinds_backend1.dto.AuthenticateRequest;
import com.example.furreverrfinds_backend1.dto.AuthenticateResponse;

public interface AuthenticateService {

    AuthenticateResponse authenticate(AuthenticateRequest authenticateRequest);

}
