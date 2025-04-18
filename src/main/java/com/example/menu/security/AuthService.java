package com.example.menu.security;

import com.example.menu.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AuthService implements UserDetailsService {

    @Autowired
    ClientRepository client;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return client.findByEmail(email);
    }
}
