package com.demo.service;

import com.demo.model.Account;
import com.demo.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new EmailValidator().isValid(username, null) ?
                accountRepository.findByEmail(username).map(this::createUserSecurity)
                .orElseThrow(() -> new UsernameNotFoundException("Username or email is invalid")) :
                accountRepository.findByUsername(username).map(this::createUserSecurity)
                .orElseThrow(() -> new UsernameNotFoundException("Username or email is invalid"));
    }

    private User createUserSecurity (Account account){
        return new User(account.getUsername(), account.getPassword(), new ArrayList<>());
    }
}
