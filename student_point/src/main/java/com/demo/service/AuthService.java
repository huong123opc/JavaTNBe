package com.demo.service;

import com.demo.dto.BaseResponse;
import com.demo.dto.request.LoginReq;
import com.demo.dto.request.SignupReq;
import com.demo.dto.response.JwtResponse;

public interface AuthService {
    JwtResponse authenticate(LoginReq loginReq);
    BaseResponse createAccount(SignupReq signupReq);
}
