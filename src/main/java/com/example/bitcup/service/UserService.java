package com.example.bitcup.service;

import com.example.bitcup.model.Account;
import com.example.bitcup.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(account.getRole().name());
        return new User(account.getLogin(), account.getPassword(), List.of(grantedAuthority));
    }

}
