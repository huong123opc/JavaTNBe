package com.demo.service.impl;

import com.demo.dto.BaseResponse;
import com.demo.dto.request.LoginReq;
import com.demo.dto.request.SignupReq;
import com.demo.dto.response.JwtResponse;
import com.demo.exception.BaseErrorException;
import com.demo.model.Account;
import com.demo.model.Student;
import com.demo.repository.AccountRepository;
import com.demo.repository.StudentRepository;
import com.demo.service.AuthService;
import com.demo.util.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AccountRepository accountRepository;
    private final StudentRepository studentRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    @Override
    public JwtResponse authenticate(LoginReq loginReq) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(auth);
            String jwtToken = jwtUtils.generateJwtToken(auth);
            UserDetails userDetails = (UserDetails) auth.getPrincipal();

            return new JwtResponse(jwtToken, "Bearer", userDetails.getUsername());
        } catch (Exception e) {
            throw new BaseErrorException("Username or password is invalid", null);
        }
    }

    @Override
    public BaseResponse createAccount(SignupReq signupReq) {
        if (accountRepository.existsByEmailOrUsername(signupReq.getEmail(), signupReq.getUsername()))
            throw new BaseErrorException("Username or email is existed", null);
        if (studentRepository.existsByStudentCode(signupReq.getStudentCode()))
            throw new BaseErrorException("Student code is existed", null);
        var student = Student.builder()
                .studentCode(signupReq.getStudentCode())
                .fullName(signupReq.getFullName())
                .classCode(signupReq.getClassCode()).build();
        var account = Account.builder()
                .student(studentRepository.save(student))
                .email(signupReq.getEmail())
                .username(signupReq.getUsername())
                .password(passwordEncoder.encode(signupReq.getPassword()))
                .build();
        accountRepository.save(account);
        return new BaseResponse("Created", signupReq.getUsername());
    }
}
